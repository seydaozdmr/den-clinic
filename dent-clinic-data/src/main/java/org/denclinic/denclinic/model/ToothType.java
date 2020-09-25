package org.denclinic.denclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="types")
public class ToothType extends BaseEntity {
    @Column(name="toothName")
    private String toothName;
    @Column(name="toothNumber")
    private int toothNumber;

    public String getDisAdi() {
        return toothName;
    }

    public void setDisAdi(String disAdi) {
        this.toothName = disAdi;
    }

    public int getDisNumarasi() {
        return toothNumber;
    }

    public void setDisNumarasi(int disNumarasi) {
        this.toothNumber = disNumarasi;
    }
}
