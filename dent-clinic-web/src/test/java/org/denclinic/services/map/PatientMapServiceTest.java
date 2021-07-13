package org.denclinic.services.map;

import org.denclinic.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PatientMapServiceTest {
    PatientMapService patientMapService;

    Integer patientId=1;
    String lastName="Kaya";

    @BeforeEach
    void setUp() {
        patientMapService=new PatientMapService(new ToothTypeMapService(),new ToothMapService());

        patientMapService.save(Patient.builder().id(patientId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Patient> patientSet = patientMapService.findAll();

        assertEquals(1,patientSet.size());
    }

    @Test
    void deleteById() {
        //id'si bilinen bir hastayı siliyoruz.
        patientMapService.deleteById(patientId);
        assertEquals(0,patientMapService.findAll().size());
    }

    @Test
    void delete() {
        //Burada findById ile geri dönen hasta nesnesini siliyoruz
        patientMapService.delete(patientMapService.findById(patientId));

        assertEquals(0,patientMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Integer id=2;
        Patient patient2=Patient.builder().id(id).build();
        Patient savedpatient=patientMapService.save(patient2);

        assertEquals(id,savedpatient.getId());
    }
    @Test
    void saveNoId(){
        Patient savepatient=patientMapService.save(Patient.builder().build());

        assertNotNull(savepatient);
        assertNotNull(savepatient.getId());
    }

    @Test
    void findById() {
        Patient patient=patientMapService.findById(patientId);
        assertEquals(patientId,patient.getId());

    }

    @Test
    void findByLastName() {
        Patient patient=patientMapService.findByLastName(lastName);
        assertNotNull(patient);
        assertEquals("Kaya",patient.getLastName());
    }
}