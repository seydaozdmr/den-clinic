package org.denclinic.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    //dişlerin tektek ziyaret ettiğini düşündüm
    //çünkü gelen bir hasta en fazla bir kaç dişine işlem yaptırabilir.



}
