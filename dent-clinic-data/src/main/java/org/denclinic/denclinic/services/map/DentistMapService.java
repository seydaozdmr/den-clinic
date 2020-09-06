package org.denclinic.denclinic.services.map;

import org.denclinic.denclinic.model.Dentist;
import org.denclinic.denclinic.services.CrudService;
import org.denclinic.denclinic.services.DentistService;

import java.util.Set;

public class DentistMapService extends AbstractMapService<Dentist,Integer> implements DentistService{

    @Override
    public Set<Dentist> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Dentist object) {
        super.delete(object);
    }

    @Override
    public Dentist save(Dentist object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Dentist findById(Integer id) {
        return super.findById(id);
    }
}
