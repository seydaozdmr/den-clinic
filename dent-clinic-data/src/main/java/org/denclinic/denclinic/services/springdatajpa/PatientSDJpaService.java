package org.denclinic.denclinic.services.springdatajpa;

import org.denclinic.denclinic.model.Patient;
import org.denclinic.denclinic.repositories.PatientRepositories;
import org.denclinic.denclinic.repositories.ToothRepository;
import org.denclinic.denclinic.repositories.ToothTypeRepository;
import org.denclinic.denclinic.services.PatientService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PatientSDJpaService  implements PatientService {
    private final PatientRepositories patientRepositories;
    private final ToothRepository toothRepository;
    private final ToothTypeRepository toothTypeRepository;

    public PatientSDJpaService(PatientRepositories patientRepositories, ToothRepository toothRepository,
                               ToothTypeRepository toothTypeRepository) {
        this.patientRepositories = patientRepositories;
        this.toothRepository = toothRepository;
        this.toothTypeRepository = toothTypeRepository;
    }

    @Override
    public Patient findByLastName(String lastName) {
        return patientRepositories.findByLastName(lastName);
    }

    @Override
    public Set<Patient> findAll() {
        Set<Patient> patients = new HashSet<>();
        patientRepositories.findAll().forEach(patients::add);
        return patients ;
    }

    @Override
    public Patient findById(Integer integer) {
        Optional<Patient> optionalPatient=patientRepositories.findById(integer);
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
        return patientRepositories.save(object);
    }

    @Override
    public void delete(Patient object) {
        patientRepositories.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        patientRepositories.deleteById(integer);
    }
}
