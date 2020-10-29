package org.denclinic.denclinic.repositories;

import org.denclinic.denclinic.model.Dentist;
import org.springframework.data.repository.CrudRepository;

public interface DentistRepository extends CrudRepository<Dentist,Integer> {
}
