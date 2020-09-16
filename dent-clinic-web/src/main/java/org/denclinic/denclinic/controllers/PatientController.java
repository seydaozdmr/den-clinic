package org.denclinic.denclinic.controllers;

import org.denclinic.denclinic.services.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/patients")
@Controller
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping({"","/","/index","/list"})
    public String listPatients(Model model){
        model.addAttribute("patients",patientService.findAll());
        return "patient/list";
    }

    @RequestMapping("/find")
    public String findPatients(){
        return "notImplemented";
    }
}
