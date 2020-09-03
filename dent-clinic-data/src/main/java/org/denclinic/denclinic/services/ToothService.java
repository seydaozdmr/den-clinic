package org.denclinic.denclinic.services;

import org.denclinic.denclinic.model.Tooth;

import java.util.Set;

public interface ToothService {
    Tooth findById(int id);
    Tooth save(Tooth tooth);
    Set<Tooth> findAll();

}
