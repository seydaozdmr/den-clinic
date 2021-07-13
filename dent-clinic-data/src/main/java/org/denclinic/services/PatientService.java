package org.denclinic.services;

import org.denclinic.model.Patient;

import java.util.List;

public interface PatientService extends CrudService<Patient,Integer> {
    Patient findByLastName(String lastName);

    List<Patient> findAllByLastNameLike(String lastName);
}
