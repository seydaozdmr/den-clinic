package org.denclinic.denclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="types")
public class ToothType extends BaseEntity {

    @Column(name="toothName")
    private String toothName;

    @Column(name="toothNumber")
    private int toothNumber;

    public String getToothName() {
        return toothName;
    }

    public void setToothName(String toothName) {
        this.toothName = toothName;
    }

    public int getToothNumber() {
        return toothNumber;
    }

    public void setToothNumber(int toothNumber) {
        this.toothNumber = toothNumber;
    }


}
