package org.denclinic.denclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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


}
