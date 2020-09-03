package org.denclinic.denclinic.services;

import org.denclinic.denclinic.model.Dentist;

import java.util.Set;

public interface DentistService {
    Dentist findById(int id);
    Dentist save(Dentist dentist);
    Set<Dentist> findAll();
}
