package org.denclinic.denclinic.services.map;

import org.denclinic.denclinic.model.Visit;
import org.denclinic.denclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
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
        if(visit.getTooth() == null || visit.getTooth().getPatient()==null || visit.getTooth().getId()==null || visit.getTooth().getPatient().getId()==null) {
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
