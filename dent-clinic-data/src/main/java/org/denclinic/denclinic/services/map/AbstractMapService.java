package org.denclinic.denclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T,ID> {
    //Bütün data buraya yüklenecek
    protected Map<ID,T> map=new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }
    //Save metodu ile gönderilen veriler map'a put edilecek...
    T save(ID id,T object){
        map.put(id,object);
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

}
