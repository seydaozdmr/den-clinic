package org.denclinic.denclinic.services.map;

import org.denclinic.denclinic.model.Patient;

import org.denclinic.denclinic.services.PatientService;


import java.util.Set;

public class PatientMapService extends AbstractMapService<Patient,Integer> implements PatientService {
    @Override
    public Set<Patient> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Patient object) {
        super.delete(object);
    }

    @Override
    public Patient save(Patient object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Patient findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Patient findByLastName(String lastName) {
        return null;
    }
}
