package org.denclinic.denclinic.controllers;

import org.denclinic.denclinic.model.Patient;
import org.denclinic.denclinic.services.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PatientControllerTest {
    @Mock
    PatientService patientService;

    @InjectMocks
    PatientController patientController;

    Set<Patient> patients;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        patients=new HashSet<>();
        patients.add(Patient.builder().id(1).build());
        patients.add(Patient.builder().id(2).build());

        mockMvc= MockMvcBuilders.standaloneSetup(patientController).build();
    }

    @Test
    void listPatients() throws Exception {
        when(patientService.findAll()).thenReturn(patients);
        //mockMvc.perform(get("/patients")).andExpect(status().is(200));
        mockMvc.perform(get("/patients"))
                .andExpect(status().isOk())
                .andExpect(view().name("patient/list"))
                .andExpect(model().attribute("patients",hasSize(2)));
    }
    @Test
    void indexPatients() throws Exception {
        when(patientService.findAll()).thenReturn(patients);
        //mockMvc.perform(get("/patients")).andExpect(status().is(200));
        mockMvc.perform(get("/patients/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("patient/list"))
                .andExpect(model().attribute("patients",hasSize(2)));
    }

    @Test
    void findPatients() throws Exception {
        mockMvc.perform(get("/patients/find"))
                .andExpect(view().name("notImplemented"));

    }
}