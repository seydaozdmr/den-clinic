package org.denclinic.denclinic.model;

import java.util.Set;

public class Patient extends Person {
    private String adress;
    private String city;
    private String telephone;
    private Set<Tooth> tooths;

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
