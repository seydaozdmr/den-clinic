package org.denclinic.denclinic.services.map;

import org.denclinic.denclinic.model.Visit;
import org.denclinic.denclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VisitMapService extends AbstractMapService<Visit,Integer> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Integer integer) {
        return super.findById(integer);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getTooths() == null || visit.getTooths().getPatient()==null || visit.getTooths().getId()==null || visit.getTooths().getPatient().getId()==null) {
            throw new RuntimeException("Geçersiz muayene");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        super.deleteById(integer);
    }
}
