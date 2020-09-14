package org.denclinic.denclinic.bootstrap;

import org.denclinic.denclinic.model.Dentist;
import org.denclinic.denclinic.model.Patient;
import org.denclinic.denclinic.model.ToothType;
import org.denclinic.denclinic.services.DentistService;
import org.denclinic.denclinic.services.PatientService;
import org.denclinic.denclinic.services.ToothTypeService;
import org.denclinic.denclinic.services.map.DentistMapService;
import org.denclinic.denclinic.services.map.PatientMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Becames spring bean
//Bootstrap data implemented in this class
@Component
public class DataLoader implements CommandLineRunner {
    private final PatientService patientService;
    private final DentistService dentistService;
    private final ToothTypeService toothTypeService;

    //@Autowired constructor olduğu için @AutoWired annotation'u kullanmamıza gerek yok
    public DataLoader(PatientService patientService, DentistService dentistService, ToothTypeService toothTypeService) {
        //Burada interface kullanıyoruz. interface'in işaret ettiği impl yapısını bulması ve kullanması gerekiyor.
        this.patientService = patientService;
        this.dentistService = dentistService;
        this.toothTypeService=toothTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        ToothType dis1=new ToothType();
        dis1.setDisAdi("SOLUST");
        dis1.setDisNumarasi(11);
        toothTypeService.save(dis1);
        ToothType dis2=new ToothType();
        dis2.setDisAdi("SOLUST");
        dis2.setDisNumarasi(12);
        toothTypeService.save(dis2);
        ToothType dis3=new ToothType();
        dis3.setDisAdi("SOLUST");
        dis3.setDisNumarasi(13);
        toothTypeService.save(dis3);

        Patient hasta1=new Patient();

        hasta1.setFirstName("Seyda");
        hasta1.setLastName("Özdemir");

        patientService.save(hasta1);

        Patient hasta2=new Patient();

        hasta2.setFirstName("Hatice");
        hasta2.setLastName("Norcu Özdemir");

        patientService.save(hasta2);
        System.out.println("Loading patients...");

        Dentist hekim1=new Dentist();

        hekim1.setFirstName("Çetin");
        hekim1.setLastName("Çalışkan");
        dentistService.save(hekim1);

        Dentist hekim2=new Dentist();

        hekim2.setFirstName("Güray");
        hekim2.setLastName("Başeğmez");

        dentistService.save(hekim2);


        System.out.println("Loaded dentists.");


    }
}
