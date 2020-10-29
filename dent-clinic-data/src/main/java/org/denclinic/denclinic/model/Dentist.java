package org.denclinic.denclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dentist")
public class Dentist extends Person {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "dentist_speciality",
            joinColumns = @JoinColumn(name = "dentist_id"),
            inverseJoinColumns = @JoinColumn(name = "speviality_id"))
    private Set<Speciality> speciality=new HashSet<>();

    public Set<Speciality> getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Set<Speciality> speciality) {
        this.speciality = speciality;
    }


}
