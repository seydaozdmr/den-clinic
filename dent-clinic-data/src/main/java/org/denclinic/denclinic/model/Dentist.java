package org.denclinic.denclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Dentist extends Person {
    private Set<Speciality> speciality=new HashSet<>();

    public Set<Speciality> getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Set<Speciality> speciality) {
        this.speciality = speciality;
    }


}
