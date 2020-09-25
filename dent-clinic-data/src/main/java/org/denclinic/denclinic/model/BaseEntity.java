package org.denclinic.denclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//JPA base class
@MappedSuperclass
public class BaseEntity {
    //BASEENTITY DİĞER SINIFLAR İÇİN BASE CLASS, ID NUMARASININ OTOMATİK OLARAK ARTTIRILMASINI İSTİYORUZ:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //AUTO-GENERATED ID NUMBER PRIMARY KEY
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
