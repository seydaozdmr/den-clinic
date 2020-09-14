package org.denclinic.denclinic.services.map;


import org.denclinic.denclinic.model.ToothType;
import org.denclinic.denclinic.services.ToothTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class ToothTypeMapService extends AbstractMapService<ToothType,Integer> implements ToothTypeService {
    @Override
    public Set<ToothType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public void delete(ToothType object) {
        super.delete(object);
    }

    @Override
    public ToothType save(ToothType object) {
        return super.save(object);
    }

    @Override
    public ToothType findById(Integer id) {
        return super.findById(id);
    }
}
