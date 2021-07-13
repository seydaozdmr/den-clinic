package org.denclinic.repositories;

import org.denclinic.model.ToothType;
import org.springframework.data.repository.CrudRepository;

public interface ToothTypeRepository extends CrudRepository<ToothType,Integer> {
}
