package org.denclinic.denclinic.services.map;

import org.denclinic.denclinic.model.Tooth;
import org.denclinic.denclinic.services.ToothService;
import org.springframework.stereotype.Service;

import java.util.Set;

//Implementing spring config (annotation congif dependency injection and ioc)
@Service
public class ToothMapService extends AbstractMapService<Tooth,Integer> implements ToothService {
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
        return super.save(object);
    }

    @Override
    public Tooth findById(Integer id) {
        return super.findById(id);
    }
}
