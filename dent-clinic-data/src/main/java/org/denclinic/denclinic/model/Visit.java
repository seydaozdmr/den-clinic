package org.denclinic.denclinic.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="visit")
public class Visit extends BaseEntity {
    @Column(name="visit_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="tooths_id")
    private Tooths tooths;
    //dişleri set olarak bir bütün olarak ziyaret ettiğini düşündüm

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tooths getTooth() {
        return tooths;
    }

    public void setTooths(Tooths tooths) {
        this.tooths = tooths;
    }
}
