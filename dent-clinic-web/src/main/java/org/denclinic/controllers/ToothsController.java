package org.denclinic.controllers;

import org.denclinic.model.Patient;
import org.denclinic.model.ToothType;
import org.denclinic.model.Tooths;
import org.denclinic.services.PatientService;
import org.denclinic.services.ToothService;
import org.denclinic.services.ToothTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("patients/{patientid}")
public class ToothsController {

    private static final String CREATE_OR_UPDATE_TOOTH_FORM="tooths/createOrUpdateToothForm";
    private final ToothService toothService;
    private final PatientService patientService;
    private final ToothTypeService toothTypeService;

    public ToothsController(ToothService toothService, PatientService patientService, ToothTypeService toothTypeService) {
        this.toothService = toothService;
        this.patientService = patientService;
        this.toothTypeService = toothTypeService;
    }
    //Avoid to repeat getting this attributes, we wrote ones
    @ModelAttribute("types")
    public Collection<ToothType> populateToothTypes(){
        return toothTypeService.findAll();
    }
    //Patient id'den hangi hasta olduğunu buluyor ve onu nesne olarak döndürüyor.
    @ModelAttribute("patient")
    public Patient findPatient (@PathVariable String patientid){
        System.out.println(patientid);
        return patientService.findById(Integer.valueOf(patientid));
    }

    @InitBinder("patient")
    public void initPatientBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }
    //yeni tooths sayfası istendiğinde hangi hastaya ait olduğu önce @ModelAttribute ile tespit ediyoruz.
    //o hastaya boş bir Tooths nesnesi instance ediyoruz ve tooth nesnesine ToothType nesnesi
    @GetMapping("/tooths/new")
    public String initCreationForm(Patient patient, Model model){
        Tooths tooth=new Tooths();
        ToothType type=new ToothType();
        tooth.setToothType(type);
        patient.getTooths().add(tooth);
        tooth.setPatient(patient);
        System.out.println(patient);
        model.addAttribute("tooth",tooth);
        return CREATE_OR_UPDATE_TOOTH_FORM;
    }

    @PostMapping("/tooths/new")
    public String processCreationForm(Patient patient,Tooths tooth, BindingResult result, Model model){
        /*
        if(StringUtils.hasLength(tooth.getToothType().getToothName()) && tooth.isNew()){
            result.rejectValue("ToothType.toothName","dublicate","allready exist");
        }

        */
        //TODO hasta buraya post'dan geliyor mu kontrol et
        ToothType savedToothType=toothTypeService.save(tooth.getToothType());
        patient.getTooths().add(tooth);
        tooth.setPatient(patient);
        if(result.hasErrors()){
            System.out.println(tooth);
            model.addAttribute("tooth",tooth);
            return CREATE_OR_UPDATE_TOOTH_FORM;
        }else{
            toothService.save(tooth);
        }
        return "redirect:/patients/"+patient.getId();
    }

    @GetMapping("/tooths/{toothid}/update")
    public String initUpdateForm(@PathVariable Integer toothid, Model model) {
        model.addAttribute("tooth", toothService.findById(toothid));
        return CREATE_OR_UPDATE_TOOTH_FORM;
    }


    @PostMapping("/tooths/{toothid}/update")
    public String processUpdateForm(@Valid Tooths tooth, BindingResult result, Patient patient, Model model) {
        if (result.hasErrors()) {
            tooth.setPatient(patient);
            model.addAttribute("tooth", tooth);
            return CREATE_OR_UPDATE_TOOTH_FORM;
        } else {
            System.out.println(tooth);
            patient.getTooths().add(tooth);
            tooth.setPatient(patient);
            toothTypeService.save(tooth.getToothType());
            toothService.save(tooth);
            return "redirect:/patients/" + patient.getId();
        }
    }



}
