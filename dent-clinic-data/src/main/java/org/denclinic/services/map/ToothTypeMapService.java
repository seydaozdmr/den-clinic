package org.denclinic.services.map;


import org.denclinic.model.ToothType;
import org.denclinic.services.ToothTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class ToothTypeMapService extends AbstractMapService<ToothType,Integer> implements ToothTypeService {
    //ToothTypeService aşağıdaki metotları Crud service'den miras olarak alıyor.
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
