package org.denclinic.denclinic.services;

import org.denclinic.denclinic.model.Patient;

import java.util.Set;

public interface PatientService extends CrudService<Patient,Integer> {
    Patient findByLastName(String lastName);
}
