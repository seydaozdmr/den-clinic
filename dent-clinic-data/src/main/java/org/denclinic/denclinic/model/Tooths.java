package org.denclinic.denclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tooths")
public class Tooths extends BaseEntity {
    @Builder
    public Tooths(Integer id,ToothType toothType,Patient patient,Set<Visit> visits){
        super(id);
        this.toothType=toothType;
        this.patient=patient;
        this.visits=visits;
    }

    @ManyToOne
    @JoinColumn(name="type_id")
    private ToothType toothType;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;
    //ManyToOne bir çok diş bir tane hastaya ait.

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tooths")
    private Set<Visit> visits=new HashSet<>();

    @Override
    public String toString() {
        return "Tooths{" +
                "toothType=" + toothType +
                ", visits=" + visits +
                '}';
    }
}
