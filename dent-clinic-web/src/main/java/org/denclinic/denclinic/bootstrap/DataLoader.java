package org.denclinic.denclinic.bootstrap;

import org.denclinic.denclinic.model.*;
import org.denclinic.denclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//Becames spring bean
//Bootstrap data implemented in this class
@Component
public class DataLoader implements CommandLineRunner {
    private final PatientService patientService;
    private final DentistService dentistService;
    private final ToothTypeService toothTypeService;
    private final SpecialitiesService specialitiesService;
    private final VisitService visitService;


    //@Autowired constructor olduğu için @AutoWired annotation'u kullanmamıza gerek yok
    public DataLoader(PatientService patientService, DentistService dentistService, ToothTypeService toothTypeService, SpecialitiesService specialitiesService, VisitService visitService) {
        //Burada interface kullanıyoruz. interface'in işaret ettiği impl yapısını bulması ve kullanması gerekiyor.
        this.patientService = patientService;
        this.dentistService = dentistService;
        this.toothTypeService=toothTypeService;
        this.specialitiesService = specialitiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count=toothTypeService.findAll().size();
        if(count==0){
            loadData();
        }

    }

    private void loadData() {
        //Diş tipleri ve detayları
        ToothType dis1=new ToothType();
        dis1.setToothName("SOLUST");
        dis1.setToothNumber(11);
        toothTypeService.save(dis1);
        ToothType dis2=new ToothType();
        dis2.setToothName("SOLUST");
        dis2.setToothNumber(12);
        toothTypeService.save(dis2);
        ToothType dis3=new ToothType();
        dis3.setToothName("SOLUST");
        dis3.setToothNumber(13);
        toothTypeService.save(dis3);

        //Hekimlerin uzmanlığı
        Speciality dentist=new Speciality();
        dentist.setDescription("Dentist");
        Speciality savedDentist=specialitiesService.save(dentist);

        Speciality dentSurgery=new Speciality();
        dentSurgery.setDescription("Çene Cerrahı");
        Speciality savedDentSurgery=specialitiesService.save(dentSurgery);

        Speciality ortoDentist=new Speciality();
        ortoDentist.setDescription("OrtoDentist");
        Speciality savedortoDentist=specialitiesService.save(ortoDentist);


        //Hastalar
        Patient hasta1=new Patient();
        hasta1.setFirstName("Seyda");
        hasta1.setLastName("Özdemir");
        hasta1.setAdress("Cumhuriyet Mah.");
        hasta1.setCity("Gazipaşa");
        hasta1.setTelephone("05437375533");
        Tooths tooths1 =new Tooths();
        tooths1.setToothType(dis1);
        tooths1.setPatient(hasta1);
        Tooths tooths2 =new Tooths();
        tooths2.setToothType(dis2);
        tooths2.setPatient(hasta1);
        hasta1.getTooths().add(tooths1);
        hasta1.getTooths().add(tooths2);
        patientService.save(hasta1);

        Patient hasta2=new Patient();
        hasta2.setFirstName("Hatice");
        hasta2.setLastName("Norcu Özdemir");
        hasta2.setAdress("Yeni Mah. Yahya Kemal Cad.");
        hasta2.setCity("Bucak");
        hasta2.setTelephone("05541213088");
        Tooths tooths3 =new Tooths();
        tooths3.setToothType(dis1);
        tooths3.setPatient(hasta2);
        Tooths tooths4 =new Tooths();
        tooths4.setToothType(dis2);
        tooths4.setPatient(hasta2);
        hasta2.getTooths().add(tooths3);
        hasta2.getTooths().add(tooths4);
        patientService.save(hasta2);
        System.out.println("Loading patients...");

        Visit muayene =new Visit();
        muayene.setTooths(tooths1);
        muayene.setDate(LocalDate.now());
        muayene.setDescription("Kanal Tedavisi");

        visitService.save(muayene);


        //Hekimler
        Dentist hekim1=new Dentist();
        hekim1.setFirstName("Çetin");
        hekim1.setLastName("Çalışkan");
        hekim1.getSpeciality().add(dentist);
        System.out.println(hekim1);
        dentistService.save(hekim1);

        Dentist hekim2=new Dentist();
        hekim2.setFirstName("Güray");
        hekim2.setLastName("Başeğmez");
        hekim2.getSpeciality().add(dentist);
        hekim2.getSpeciality().add(ortoDentist);
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
