package org.denclinic.denclinic.repositories;

import org.denclinic.denclinic.model.Tooths;
import org.springframework.data.repository.CrudRepository;

public interface ToothRepository extends CrudRepository<Tooths,Integer> {
}
