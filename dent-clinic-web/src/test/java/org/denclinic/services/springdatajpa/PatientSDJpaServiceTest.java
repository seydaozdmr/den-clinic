package org.denclinic.services.springdatajpa;

import org.denclinic.model.Patient;
import org.denclinic.repositories.PatientRepository;
import org.denclinic.repositories.ToothRepository;
import org.denclinic.repositories.ToothTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatientSDJpaServiceTest {

    @Mock
    PatientRepository patientRepository;
    @Mock
    ToothRepository toothRepository;
    @Mock
    ToothTypeRepository toothTypeRepository;

    @InjectMocks
    PatientSDJpaService patientSDJpaService;

    Patient returnpatient;
    @BeforeEach
    void setUp() {
        returnpatient=Patient.builder().id(1).lastName("YILDIRIM").build();
        //patientSDJpaService.save(Patient.builder().id(1).lastName("Yılmaz").build());
    }

    @Test
    void findByLastName() {
        Patient returnPatient=Patient.builder().id(1).lastName("Ozdemir").build();

        when(patientRepository.findByLastName(any())).thenReturn(returnPatient);

        Patient aranan=patientSDJpaService.findByLastName("Ozdemir");

        assertEquals("Ozdemir",aranan.getLastName());
    }

    @Test
    void findAll() {
        Set<Patient> patientSet=patientSDJpaService.findAll();
        patientSet.add(Patient.builder().id(1).build());
        patientSet.add(Patient.builder().id(2).build());

        when(patientRepository.findAll()).thenReturn(patientSet);

        Set<Patient> patients=patientSDJpaService.findAll();

        assertEquals(2,patients.size());
    }

    @Test
    void findById() {
        when(patientRepository.findById(anyInt())).thenReturn(Optional.of(returnpatient));
        Patient patient=patientSDJpaService.findById(1);
        assertNotNull(patient);
    }

    @Test
    void findByIdorFould() {
        when(patientRepository.findById(anyInt())).thenReturn(Optional.empty());
        Patient patient=patientSDJpaService.findById(1);
        assertNull(patient);
    }

    @Test
    void save() {
        Patient patient2=Patient.builder().id(1).build();

        when(patientRepository.save(any())).thenReturn(patient2);

        Patient savedpatient=patientSDJpaService.save(patient2);

        assertNotNull(savedpatient);

    }

    @Test
    void delete() {
        patientSDJpaService.delete(returnpatient);

        verify(patientRepository,times(1)).delete(any());
    }
    @Test
    void deleteById() {
        patientSDJpaService.deleteById(1);
        verify(patientRepository).deleteById(anyInt());
    }
}