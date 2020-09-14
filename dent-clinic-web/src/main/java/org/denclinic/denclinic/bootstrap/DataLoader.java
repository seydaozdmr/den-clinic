package org.denclinic.denclinic.bootstrap;

import org.denclinic.denclinic.model.Dentist;
import org.denclinic.denclinic.model.Patient;
import org.denclinic.denclinic.model.Tooth;
import org.denclinic.denclinic.model.ToothType;
import org.denclinic.denclinic.services.DentistService;
import org.denclinic.denclinic.services.PatientService;
import org.denclinic.denclinic.services.ToothTypeService;
import org.denclinic.denclinic.services.map.AbstractMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

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
        hasta1.setAdress("Cumhuriyet Mah.");
        hasta1.setCity("Gazipaşa");
        hasta1.setTelephone("05437375533");
        Tooth tooth1=new Tooth();
        tooth1.setToothType(dis1);
        tooth1.setPatient(hasta1);
        Tooth tooth2=new Tooth();
        tooth2.setToothType(dis2);
        tooth2.setPatient(hasta1);
        hasta1.getTooths().add(tooth1);
        hasta1.getTooths().add(tooth2);
        patientService.save(hasta1);

        Patient hasta2=new Patient();
        hasta2.setFirstName("Hatice");
        hasta2.setLastName("Norcu Özdemir");
        hasta2.setAdress("Yeni Mah. Yahya Kemal Cad.");
        hasta2.setCity("Bucak");
        hasta2.setTelephone("05541213088");
        Tooth tooth3=new Tooth();
        tooth3.setToothType(dis1);
        tooth3.setPatient(hasta2);
        Tooth tooth4=new Tooth();
        tooth4.setToothType(dis2);
        tooth4.setPatient(hasta2);
        hasta2.getTooths().add(tooth3);
        hasta2.getTooths().add(tooth4);
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
        /*TEST AREA
        Set<Dentist> dentists=dentistService.findAll();
        for(Dentist dentist:dentists){
            System.out.println(dentist.getFirstName()+" "+dentist.getLastName());
        }
        */
    }
}
