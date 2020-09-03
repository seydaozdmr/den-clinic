package org.denclinic.denclinic.model;

public class ToothType extends BaseEntity {
    private String disAdi;
    private int disNumarasi;

    public String getDisAdi() {
        return disAdi;
    }

    public void setDisAdi(String disAdi) {
        this.disAdi = disAdi;
    }

    public int getDisNumarasi() {
        return disNumarasi;
    }

    public void setDisNumarasi(int disNumarasi) {
        this.disNumarasi = disNumarasi;
    }
}
