package org.denclinic.denclinic.model;

import java.util.Set;

public class Patient extends Person {
    private Set<Tooth> tooths;

    public Set<Tooth> getTooths() {
        return tooths;
    }

    public void setTooths(Set<Tooth> tooths) {
        this.tooths = tooths;
    }


}
