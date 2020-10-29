package org.denclinic.denclinic.repositories;

import org.denclinic.denclinic.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepositories extends CrudRepository<Patient,Integer> {
    Patient findByLastName(String lastName);
}
