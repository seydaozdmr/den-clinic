package org.denclinic.denclinic.services.map;

import org.denclinic.denclinic.model.Tooths;
import org.denclinic.denclinic.services.ToothService;
import org.springframework.stereotype.Service;

import java.util.Set;

//Implementing spring config (annotation congif dependency injection and ioc)
@Service
public class ToothMapService extends AbstractMapService<Tooths,Integer> implements ToothService {
    @Override
    public Set<Tooths> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Tooths object) {
        super.delete(object);
    }

    @Override
    public Tooths save(Tooths object) {
        return super.save(object);
    }

    @Override
    public Tooths findById(Integer id) {
        return super.findById(id);
    }
}
