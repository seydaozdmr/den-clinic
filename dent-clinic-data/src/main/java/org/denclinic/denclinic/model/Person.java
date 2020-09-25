package org.denclinic.denclinic.model;




import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


//veritabanında direkt tablo olarak yer almayacak fakat oluşturulacak diğer tabloların türetilmesine yarayacak superclass-base class
//diğer sınıflar bu sınıftan miras alacak aynen bu sınıfın baseentitty sınıfından miras aldığı gibi.
@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
