package org.denclinic.repositories;

import org.denclinic.model.Tooths;
import org.springframework.data.repository.CrudRepository;

public interface ToothRepository extends CrudRepository<Tooths,Integer> {
}
