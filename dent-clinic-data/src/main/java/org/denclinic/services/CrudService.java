package org.denclinic.services;

import java.util.Set;

public interface CrudService<T,ID> {
    //T tipindeki elemenların listelenmesi, id'ye göre bulunması, kaydedilmesi,silinmesi
    // service yapılarında tekrar eden yapıların genel olarak bir interface altında ifade edilmesi
    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);

}
