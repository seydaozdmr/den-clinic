package org.denclinic.denclinic.controllers;

import org.denclinic.denclinic.model.Patient;
import org.denclinic.denclinic.services.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/patients")
@Controller
public class PatientController {
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

    @RequestMapping("/find")
    public String findPatients(Model model){
        model.addAttribute("patient", Patient.builder().build());
        return "patient/findPatients";
    }

    //Hastalar sayfasının bu metot yardımıyle açılmasını istiyorum
    @GetMapping()
    public String processFindForm(Patient patient, BindingResult result,Model model){
        // eğer parametresiz GET request gerçekleşirse tüm kayıtları geri dön
        if(patient.getLastName()==null){
            patient.setLastName("");
        }

        List<Patient> results= patientService.findAllByLastNameLike(patient.getLastName());

        if(results.isEmpty()){
            result.rejectValue("lastName","notFound","not Found");
            return "patient/findPatients";
        }else if(results.size()==1){
            patient=results.iterator().next();
            return "redirect:/patients/"+patient.getId();
        }else {
            model.addAttribute("selections", results);
            return "patient/patientsList";
        }
    }

    @GetMapping("/{patientid}")
    public ModelAndView showPatient(@PathVariable String patientid){
        ModelAndView modelAndView=new ModelAndView("patient/patientDetails");
        modelAndView.addObject(patientService.findById(Integer.valueOf(patientid)));
        return modelAndView;
    }

}
