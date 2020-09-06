package org.denclinic.denclinic.controllers;

import org.denclinic.denclinic.services.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping("/patients")
    public String listPatients(Model model){
        model.addAttribute("patients",patientService.findAll());
        return "patient/list";
    }
}
