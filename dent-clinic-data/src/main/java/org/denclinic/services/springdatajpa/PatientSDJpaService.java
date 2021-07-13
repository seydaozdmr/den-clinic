package org.denclinic.services.springdatajpa;

import org.denclinic.model.Patient;
import org.denclinic.repositories.PatientRepository;
import org.denclinic.repositories.ToothRepository;
import org.denclinic.repositories.ToothTypeRepository;
import org.denclinic.services.PatientService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PatientSDJpaService  implements PatientService {
    private final PatientRepository patientRepository;
    private final ToothRepository toothRepository;
    private final ToothTypeRepository toothTypeRepository;

    public PatientSDJpaService(PatientRepository patientRepository, ToothRepository toothRepository,
                               ToothTypeRepository toothTypeRepository) {
        this.patientRepository = patientRepository;
        this.toothRepository = toothRepository;
        this.toothTypeRepository = toothTypeRepository;
    }

    @Override
    public Patient findByLastName(String lastName) {
        return patientRepository.findByLastName(lastName);
    }

    @Override
    public List<Patient> findAllByLastNameLike(String lastName) {


        return patientRepository.findAllByLastNameLike(lastName);
    }

    @Override
    public Set<Patient> findAll() {
        Set<Patient> patients = new HashSet<>();
        patientRepository.findAll().forEach(patients::add);
        return patients ;
    }

    @Override
    public Patient findById(Integer integer) {
        Optional<Patient> optionalPatient= patientRepository.findById(integer);
        if(optionalPatient.isPresent()){
            return optionalPatient.get();
        }else {
            return null;
        }
        //üstteki kodun daha yalın yazılışı:
        //return patientRepositories.findById(integer).orElse(null);
    }

    @Override
    public Patient save(Patient object) {
        return patientRepository.save(object);
    }

    @Override
    public void delete(Patient object) {
        patientRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        patientRepository.deleteById(integer);
    }
}
