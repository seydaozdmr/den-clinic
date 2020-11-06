package org.denclinic.denclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="patients")
public class Patient extends Person {
    @Column(name="adress")
    private String adress;
    @Column(name="city")
    private String city;
    @Column(name="telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient")
    private Set<Tooths> tooths = new HashSet<>();   //Hastanın dişleri var OneToMany bir hastanın çok dişi var


}
//JPA persistence entity
