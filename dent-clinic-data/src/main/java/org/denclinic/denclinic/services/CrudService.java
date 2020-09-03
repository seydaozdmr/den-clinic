package org.denclinic.denclinic.services;

import java.util.Set;

public interface CrudService<T,ID> {
    //T tipindeki elemenların listelenmesi, id'ye göre bulunması, kaydedilmesi,silinmesi
    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);

}
