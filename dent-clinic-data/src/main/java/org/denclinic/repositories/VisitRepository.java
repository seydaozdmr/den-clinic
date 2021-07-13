package org.denclinic.repositories;

import org.denclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Integer> {
}
