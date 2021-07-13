package org.denclinic.controllers;

import org.denclinic.services.DentistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DentistController {
    private final DentistService dentistService;

    //Burada dependency injection gerçekleştiriyoruz. Dentist Service burada instance edilmiyor.
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @RequestMapping("/dentists")
    public String listDentsits(Model model){

        model.addAttribute("dentists",dentistService.findAll());

        return "dentist/list";
    }
}
