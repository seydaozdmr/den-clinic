package org.denclinic.denclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//JPA persistence entity
@Entity
@Table(name="patients")
public class Patient extends Person {
    @Column(name="adress")
    private String adress;
    @Column(name="city")
    private String city;
    @Column(name="telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient")
    private Set<Tooth> tooths = new HashSet<>();

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Tooth> getTooths() {
        return tooths;
    }

    public void setTooths(Set<Tooth> tooths) {
        this.tooths = tooths;
    }
}
