package org.denclinic.denclinic.model;

import javax.persistence.*;

@Entity
@Table(name="tooths")
public class Tooth extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="type_id")
    private ToothType toothType;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;


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
}
