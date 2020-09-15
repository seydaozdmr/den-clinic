package org.denclinic.denclinic.services.map;

import org.denclinic.denclinic.model.Dentist;
import org.denclinic.denclinic.model.Speciality;
import org.denclinic.denclinic.services.DentistService;
import org.denclinic.denclinic.services.SpecialitiesService;
import org.springframework.stereotype.Service;

import java.util.Set;

//Implementing spring config (annotation congif dependency injection and ioc)
@Service
public class DentistMapService extends AbstractMapService<Dentist,Integer> implements DentistService{
    private final SpecialitiesService specialitiesService;
    //AutoWired
    public DentistMapService(SpecialitiesService specialitiesService) {
        this.specialitiesService = specialitiesService;
    }

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
        if(object.getSpeciality().size()>0){
            object.getSpeciality().forEach(speciality -> {
                if(speciality.getId()==null){
                    Speciality savedSpecialty = specialitiesService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Dentist findById(Integer id) {
        return super.findById(id);
    }
}
