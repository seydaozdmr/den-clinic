package org.denclinic.controllers;

import org.denclinic.model.Patient;
import org.denclinic.services.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.validation.Valid;

@RequestMapping("/patients")
@Controller
public class PatientController {
    //static file createOrUpdatePatient
    private static final String CREATE_OR_UPDATE_PATIENT_FORM="patient/createOrUpdatePatientForm";
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @InitBinder
    public void setAllowedFiels(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }
//Burayı kullanmıyorum
//    @RequestMapping({"","/","/index","/list"})
//    public String listPatients(Model model){
//        model.addAttribute("patients",patientService.findAll());
//        return "patient/list";
//    }
    //
    @GetMapping("/find")
    public String findPatients(Model model){
        //find sayfasına bir patient nesnesi gönderiyoruz.
        model.addAttribute("patient", Patient.builder().build());
        return "patient/findPatients";
    }

    //Hastalar sayfasının bu metot yardımıyle açılmasını istiyorum
    //find sayfasındaki arama form'u action olarak patients döndürüyor. Oradan aşağıdaki processFindForm'a dönüyoruz.
    //patient olarak gelen nesnenin yalnızca lastName property'si dolu olarak geliyor.
    @GetMapping
    public String processFindForm(Patient patient, BindingResult result,Model model){
        // eğer parametresiz GET request gerçekleşirse tüm kayıtları geri dön
        if(patient.getLastName()==null){
            patient.setLastName("");
        }
        //eğer formu boş olarak ara tuşuna basarsak yukarıda lastName özelliğine "" boşluk karakteri atanıyor.
        //altta patientService yardımıyla arama gerçekleştiriyoruz.
        //eğer form boşsa bütün hastaları liste olarak geri döndürüyor.
        List<Patient> results= patientService.findAllByLastNameLike('%'+patient.getLastName()+'%');
        //eğer form doldurulup aranan hasta bulunamışsa
        if(results.isEmpty()){
            result.rejectValue("lastName","notFound","not Found");
            //hasta arama sayfasına hata koduyla beraber geri dönüyoruz
            return "patient/findPatients";
        }else if(results.size()==1){
            //eğer bir kişi bulmuşsak o kişinin sayfasına yönlendiriliyoruz.
            patient=results.iterator().next();
            return "redirect:/patients/"+patient.getId();
        }else {
            //eğer birden çok kişi bulmuşsak patient/patientsList sayfasına hasta listesini gönderiyoruz.
            model.addAttribute("selections", results);
            return "patient/patientsList";
        }
    }

    @GetMapping("/{patientid}")
    public ModelAndView showPatient(@PathVariable String patientid){
        //ModelAndView ile view sayfasını modelAndView nesnesine ekliyoruz.
        ModelAndView modelAndView=new ModelAndView("patient/patientDetails");
        modelAndView.addObject("patient",patientService.findById(Integer.valueOf(patientid)));
        return modelAndView;
    }

    //NEW PATIENT
    @GetMapping("/new")
    public String initCreateForm(Model model){
        Patient patient=Patient.builder().build();
        model.addAttribute("patient",patient);
        return CREATE_OR_UPDATE_PATIENT_FORM;
    }

    @PostMapping("/new")
    public String processCreatingForm(@Valid Patient patient,BindingResult result){
        if(result.hasErrors()){
            return CREATE_OR_UPDATE_PATIENT_FORM;
        }else{
            Patient savedPatient=patientService.save(patient);
            return "redirect:/patients/"+savedPatient.getId();
        }
    }

    //UPDATE PATIENT
    @GetMapping("/{patientid}/update")
    public String initUpdatePatientForm(@PathVariable String patientid, Model model){
        Patient patient=patientService.findById(Integer.valueOf(patientid));
        model.addAttribute("patient",patient);
        return CREATE_OR_UPDATE_PATIENT_FORM;
    }

    @PostMapping("/{patientid}/update")
    public String processUpdatePatientForm(@Valid Patient patient, BindingResult result, @PathVariable Integer patientid){
        if(result.hasErrors()){
            return CREATE_OR_UPDATE_PATIENT_FORM;
        }else{
            patient.setId(patientid);
            Patient savedPatient=patientService.save(patient);
            return "redirect:/patients/"+savedPatient.getId();
        }
    }







}
