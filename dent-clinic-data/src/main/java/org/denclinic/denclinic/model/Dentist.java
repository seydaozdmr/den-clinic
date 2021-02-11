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
@Table(name = "dentist")
public class Dentist extends Person {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "dentist_speciality",
            joinColumns = @JoinColumn(name = "dentist_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> speciality=new HashSet<>();



}
