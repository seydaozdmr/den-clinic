package org.denclinic.repositories;

import org.denclinic.model.Dentist;
import org.springframework.data.repository.CrudRepository;

public interface DentistRepository extends CrudRepository<Dentist,Integer> {
}
