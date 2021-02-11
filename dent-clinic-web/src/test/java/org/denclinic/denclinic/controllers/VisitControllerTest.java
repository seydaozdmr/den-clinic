package org.denclinic.denclinic.controllers;

import org.denclinic.denclinic.model.Patient;
import org.denclinic.denclinic.model.ToothType;
import org.denclinic.denclinic.model.Tooths;
import org.denclinic.denclinic.services.ToothService;
import org.denclinic.denclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {
    private static final String TOOTH_CREATE_OR_UPDATE_VISIT_FROM="tooths/createOrUpdateVisitForm";
    private static final String REDIRECT_PATIENT_1="redirect:/patients/{patientid}";
    private static final String YET_ANOTHER_VISIT_DESCRIPTION="yet another visit";

    @Mock
    ToothService toothService;

    @Mock
    VisitService visitService;

    @InjectMocks
    VisitController visitController;

    private MockMvc mockMvc;

    private final UriTemplate visitUriTemplate=new UriTemplate("/patients/{patientid}/tooths/{toothid}/visits/new");
    private final Map<String,String> uriVariables=new HashMap<>();
    private URI visitUri;

    @BeforeEach
    void setUp() {
        Integer toothId=1;
        Integer patinetId=1;
        when(toothService.findById(anyInt())).thenReturn(
                Tooths.builder()
                .id(toothId)
                .visits(new HashSet<>())
                .patient(Patient.builder()
                .id(patinetId)
                .firstName("Hasan")
                .lastName("Yılmaz").build())
                .toothType(ToothType.builder()
                .toothName("SOLUST")
                .toothNumber(12).build())
                .build()
        );
        uriVariables.clear();
        uriVariables.put("patientid",patinetId.toString());
        uriVariables.put("toothid",toothId.toString());
        visitUri=visitUriTemplate.expand(uriVariables);

        mockMvc= MockMvcBuilders
                .standaloneSetup(visitController)
                .build();
    }

    @Test
    void setAllowedFields() {
    }

    @Test
    void loadToothWithVisit() {
    }

    @Test
    void initNewVisitForm() throws Exception {
        mockMvc.perform(get(visitUri))
                .andExpect(status().isOk())
                .andExpect(view().name(TOOTH_CREATE_OR_UPDATE_VISIT_FROM));

    }

    @Test
    void processNewVisitForm() throws Exception {
        mockMvc.perform(post(visitUri)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("date","2020-11-11")
                .param("description",YET_ANOTHER_VISIT_DESCRIPTION))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name(REDIRECT_PATIENT_1))
                .andExpect(model().attributeExists("visit"));


    }
}