package org.denclinic.denclinic.services.map;

import org.denclinic.denclinic.model.Tooth;
import org.denclinic.denclinic.services.CrudService;

import java.util.Set;

public class ToothMapService extends AbstractMapService<Tooth,Integer> implements CrudService<Tooth,Integer> {
    @Override
    public Set<Tooth> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Tooth object) {
        super.delete(object);
    }

    @Override
    public Tooth save(Tooth object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Tooth findById(Integer id) {
        return super.findById(id);
    }
}
