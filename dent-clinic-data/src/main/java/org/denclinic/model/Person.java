package org.denclinic.model;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


//veritabanında direkt tablo olarak yer almayacak fakat oluşturulacak diğer tabloların türetilmesine yarayacak superclass-base class
//diğer sınıflar bu sınıftan miras alacak aynen bu sınıfın baseentitty sınıfından miras aldığı gibi.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    public Person(Integer id,String firstName,String lastName){
        super(id);
        this.firstName=firstName;
        this.lastName=lastName;

    }

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;



}
