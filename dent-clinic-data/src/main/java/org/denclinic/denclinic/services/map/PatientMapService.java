package org.denclinic.denclinic.services.map;

import org.denclinic.denclinic.model.Patient;
import org.denclinic.denclinic.model.Tooths;
import org.denclinic.denclinic.services.PatientService;
import org.denclinic.denclinic.services.ToothService;
import org.denclinic.denclinic.services.ToothTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

//Implementing spring config (annotation congif dependency injection and ioc)
@Service
public class PatientMapService extends AbstractMapService<Patient,Integer> implements PatientService {
    private final ToothTypeService toothTypeService;
    private final ToothService toothService;
    //Dependency injection
    public PatientMapService(ToothTypeService toothTypeService, ToothService toothService) {
        this.toothTypeService = toothTypeService;
        this.toothService = toothService;
    }

    @Override
    public Set<Patient> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Patient object) {
        super.delete(object);
    }

    //normalde yukarıda kullandığımız şekilde super'de (AbstractMapService) tanımlanmış metodu kullanabiliriz.
    //Bu şekilde benzer işler için tekrar tekrar metot yazmaktan kurtuluruz.
    //Bunun yanında
    @Override
    public Patient save(Patient object) {
        if(object!=null){
            if(object.getTooths()!=null){
                //kişiye ait herbir diş getTooths ile set olan liste üzerinden iterasyon yapılıyor.
                //eğer elde  ettiğimiz dişin tip bilgileri (yeri ve numarası) bulunmuyorsa
                //
                object.getTooths().forEach(tooth -> {
                    if(tooth.getToothType()!=null){
                        //sıradaki dişin tipinin id numası yok ise
                        //tekrar kaydediyoruz.
                        if(tooth.getToothType().getId()==null){
                            //diş tipi servisi ile o anki dişin tipini öğrenip tekrar kayıt gerçekleştiriyoruz.
                            tooth.setToothType(toothTypeService.save(tooth.getToothType())); //diş tipini geri gönderiyor
                        }
                    }else{
                        throw new RuntimeException("Tooth type is requared");
                    }
                    if(tooth.getId()==null){
                        Tooths savedTooths = toothService.save(tooth);
                        tooth.setId(savedTooths.getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }


    }

    @Override
    public Patient findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Patient findByLastName(String lastName) {
        return null;
    }
}
