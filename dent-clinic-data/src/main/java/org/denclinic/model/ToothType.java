package org.denclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="types")
public class ToothType extends BaseEntity {

    @Column(name="toothName")
    private String toothName;

    @Column(name="toothNumber")
    private int toothNumber;

    @Builder
    public ToothType(Integer id,String toothName,int toothNumber){
        super(id);
        this.toothName=toothName;
        this.toothNumber=toothNumber;
    }

    @Override
    public String toString() {
        return "ToothType{" +
                "toothName='" + toothName + '\'' +
                ", toothNumber=" + toothNumber +
                '}';
    }
}
