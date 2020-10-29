package org.denclinic.denclinic.services.springdatajpa;

import org.denclinic.denclinic.model.Dentist;
import org.denclinic.denclinic.repositories.DentistRepository;
import org.denclinic.denclinic.services.DentistService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class DentistSDJpaService implements DentistService {
    private final DentistRepository dentistRepository;

    public DentistSDJpaService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Set<Dentist> findAll() {
        Set<Dentist> dentists=new HashSet<>();
        dentistRepository.findAll().forEach((dentists::add));
        return dentists;
    }

    @Override
    public Dentist findById(Integer integer) {
        return dentistRepository.findById(integer).orElse(null);
    }

    @Override
    public Dentist save(Dentist object) {
        return dentistRepository.save(object);
    }

    @Override
    public void delete(Dentist object) {
        dentistRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        dentistRepository.deleteById(integer);
    }
}
