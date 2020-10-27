package org.denclinic.denclinic.services.map;

import org.denclinic.denclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Integer> {
    //Bütün data buraya yüklenecek
    protected Map<Integer,T> map=new HashMap<>();

    //Yüklenen data'nın tipine göre bütün değerleri alan metot
    Set<T> findAll(){
        return new HashSet<>(map.values());
    }
    //T tipinde ID'ye göre değerleri getiren metot
    T findById(ID id){
        return map.get(id);
    }

    //Save metodu ile gönderilen veriler map'a put edilecek...
    T save(T object){  //T tipinde gelen bütün verileri yukardaki map'e ekleyen metot
        if(object!=null) {
            if (object.getId() == null) {
                object.setId(getNextID());
            }
            map.put(object.getId(), object);
        }else{
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Integer getNextID(){
        Integer nextId=null;
        try {
            nextId=Collections.max(map.keySet())+1;
        }catch(NoSuchElementException e){
            nextId=1;
        }
        return nextId;
    }

}
