package org.denclinic.denclinic.services;

import org.denclinic.denclinic.model.Patient;

import java.util.Set;

public interface PatientService {
    Patient findByLastName(String lastName);
    Patient findById(int id);
    Patient save(Patient patient);
    Set<Patient> findAll();
}
