package org.denclinic.services.springdatajpa;

import org.denclinic.model.Tooths;
import org.denclinic.repositories.ToothRepository;
import org.denclinic.services.ToothService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class ToothSDJpaService implements ToothService {
    private final ToothRepository toothRepository;

    public ToothSDJpaService(ToothRepository toothRepository) {
        this.toothRepository = toothRepository;
    }

    @Override
    public Set<Tooths> findAll() {
        Set<Tooths> tooths=new HashSet<>();
        toothRepository.findAll().forEach(tooths::add);
        return tooths;
    }

    @Override
    public Tooths findById(Integer integer) {
        return toothRepository.findById(integer).orElse(null);
    }

    @Override
    public Tooths save(Tooths object) {
        return toothRepository.save(object);
    }

    @Override
    public void delete(Tooths object) {
        toothRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        toothRepository.deleteById(integer);
    }
}
