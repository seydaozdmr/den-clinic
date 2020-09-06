package org.denclinic.denclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientController {
    @RequestMapping("/patients")
    public String listPatients(){

        return "patient/list";
    }
}
