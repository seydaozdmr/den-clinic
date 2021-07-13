package org.denclinic.controllers;

import org.denclinic.model.Patient;
import org.denclinic.model.ToothType;
import org.denclinic.services.PatientService;
import org.denclinic.services.ToothService;
import org.denclinic.services.ToothTypeService;
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

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ToothsControllerTest {
    @Mock
    ToothService toothService;

    @Mock
    PatientService patientService;

    @Mock
    ToothTypeService toothTypeService;

    @InjectMocks
    ToothsController toothsController;

    MockMvc mockMvc;

    Patient patient;
    Set<ToothType> toothTypes;

    @BeforeEach
    void setUp() {
        patient=Patient.builder().id(1).build();

        toothTypes=new HashSet<>();
        toothTypes.add(ToothType.builder().id(1).toothName("SOLUST").build());
        toothTypes.add(ToothType.builder().id(2).toothName("SAGALT").build());

        mockMvc= MockMvcBuilders
                .standaloneSetup(toothsController)
                .build();
    }

    @Test
    void initCreationForm() throws Exception{
        when(patientService.findById(anyInt())).thenReturn(patient);
        when(toothTypeService.findAll()).thenReturn(toothTypes);

        mockMvc.perform(get("/patients/1/tooths/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("patient"))
                .andExpect(model().attributeExists("tooth"))
                .andExpect(view().name("tooths/createOrUpdateToothForm"));
    }

    @Test
    void populateToothTypes() {
    }

    @Test
    void findPatient() {
    }

    @Test
    void initPatientBinder() {
    }
}