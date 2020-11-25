package org.denclinic.denclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="patients")
public class Patient extends Person {

    @Builder
    public Patient(Integer id,String firstName,String lastName,String adress, String city,String telephone,Set<Tooths> tooths){
        super(id,firstName,lastName);
        this.adress=adress;
        this.city=city;
        this.telephone=telephone;
        if(tooths!=null){
            this.tooths=tooths;
        }
    }

    @Column(name="adress")
    private String adress;
    @Column(name="city")
    private String city;
    @Column(name="telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient")
    private Set<Tooths> tooths = new HashSet<>();   //Hastanın dişleri var OneToMany bir hastanın çok dişi var


    @Override
    public String toString() {
        return "Patient{" +
                "adress='" + adress + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                ", tooths=" + tooths +
                '}';
    }
}
//JPA persistence entity
