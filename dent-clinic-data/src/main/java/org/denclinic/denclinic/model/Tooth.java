package org.denclinic.denclinic.model;

public class Tooth extends BaseEntity {
    private ToothType toothType;
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
