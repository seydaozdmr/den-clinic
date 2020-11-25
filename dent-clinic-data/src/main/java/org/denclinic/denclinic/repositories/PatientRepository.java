package org.denclinic.denclinic.repositories;

import org.denclinic.denclinic.model.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient,Integer> {
    Patient findByLastName(String lastName);

    List<Patient> findAllByLastNameLike(String lastName);
}
