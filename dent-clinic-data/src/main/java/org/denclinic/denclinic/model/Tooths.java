package org.denclinic.denclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tooths")
public class Tooths extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="type_id")
    private ToothType toothType;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;
    //ManyToOne bir çok diş bir tane hastaya ait.

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tooths")
    private Set<Visit> visits=new HashSet<>();


    public ToothType getToothType() {
        return toothType;
    }

    public void setToothType(ToothType toothType) {
        this.toothType = toothType;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }
}