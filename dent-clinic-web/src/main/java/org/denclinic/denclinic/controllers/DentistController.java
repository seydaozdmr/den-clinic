package org.denclinic.denclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DentistController {

    @RequestMapping("/dentists")
    public String listVets(){

        return "dentist/list";
    }
}
