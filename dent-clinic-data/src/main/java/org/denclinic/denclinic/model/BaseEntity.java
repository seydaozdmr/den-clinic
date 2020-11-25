package org.denclinic.denclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

//JPA base class
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {
    //BASEENTITY DİĞER SINIFLAR İÇİN BASE CLASS, ID NUMARASININ OTOMATİK OLARAK ARTTIRILMASINI İSTİYORUZ:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //AUTO-GENERATED ID NUMBER PRIMARY KEY
    private Integer id;
    //Getter and setter hide by lombok

    public boolean isNew(){
        return this.id==null;
    }
}
