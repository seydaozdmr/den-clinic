package org.denclinic.denclinic.services.map;

import org.denclinic.denclinic.model.Speciality;
import org.denclinic.denclinic.services.SpecialitiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class SpecialityMapService extends AbstractMapService<Speciality,Integer> implements SpecialitiesService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Integer id) {
        return super.findById(id);
    }
}
