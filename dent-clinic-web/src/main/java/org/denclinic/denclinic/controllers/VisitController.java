package org.denclinic.denclinic.controllers;

import org.denclinic.denclinic.model.Patient;
import org.denclinic.denclinic.model.Tooths;
import org.denclinic.denclinic.model.Visit;
import org.denclinic.denclinic.services.PatientService;
import org.denclinic.denclinic.services.ToothService;
import org.denclinic.denclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class VisitController {
    private final VisitService visitService;
    private final ToothService toothService;
    private final PatientService patientService;

    public VisitController(VisitService visitService, ToothService toothService, PatientService patientService) {
        this.visitService = visitService;
        this.toothService = toothService;
        this.patientService = patientService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit loadToothWithVisit(@PathVariable("toothid") String toothid,@PathVariable("patientid") String patientid, Model model){
        Tooths tooth=toothService.findById(Integer.valueOf(toothid));
        //Patient patient=patientService.findById(Integer.valueOf(patientid));
        //System.out.println(tooth);
        //patient.getTooths().add(tooth);
        model.addAttribute("tooth",tooth);
        //model.addAttribute("patient",patient);
        Visit visit=new Visit();
        tooth.getVisits().add(visit);
        visit.setTooths(tooth);
        return visit;
    }

    @GetMapping("/patients/{patientid}/tooths/{toothid}/visits/new")
    public String initNewVisitForm(@PathVariable("toothid") Integer toothid, Model model) {
        System.out.println("model: "+model);
        return "tooths/createOrUpdateVisitForm";
    }

    // Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is called
    @PostMapping("/patients/{patientid}/tooths/{toothid}/visits/new")
    public String processNewVisitForm(Visit visit, BindingResult result) {
        System.out.println(visit);
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        } else {
            visitService.save(visit);

            return "redirect:/patients/{patientid}";
        }
    }


}
