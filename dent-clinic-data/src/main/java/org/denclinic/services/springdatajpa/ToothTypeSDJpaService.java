package org.denclinic.services.springdatajpa;

import org.denclinic.model.ToothType;
import org.denclinic.repositories.ToothTypeRepository;
import org.denclinic.services.ToothTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class ToothTypeSDJpaService implements ToothTypeService {
    private final ToothTypeRepository toothTypeRepository;

    public ToothTypeSDJpaService(ToothTypeRepository toothTypeRepository) {
        this.toothTypeRepository = toothTypeRepository;
    }

    @Override
    public Set<ToothType> findAll() {
        Set<ToothType> toothTypes=new HashSet<>();
        toothTypeRepository.findAll().forEach(toothTypes::add);
        return toothTypes;
    }

    @Override
    public ToothType findById(Integer integer) {
        return toothTypeRepository.findById(integer).orElse(null);
    }

    @Override
    public ToothType save(ToothType object) {
        return toothTypeRepository.save(object);
    }

    @Override
    public void delete(ToothType object) {
        toothTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        toothTypeRepository.deleteById(integer);
    }
}
