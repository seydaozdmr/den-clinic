package org.denclinic.denclinic.model;

import java.time.LocalDate;
import java.util.Set;

public class Visit extends BaseEntity {
    private LocalDate date;
    private String description;
    private Set<Tooth> tooths;

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

    public Set<Tooth> getTooths() {
        return tooths;
    }

    public void setTooths(Set<Tooth> tooths) {
        this.tooths = tooths;
    }
}
