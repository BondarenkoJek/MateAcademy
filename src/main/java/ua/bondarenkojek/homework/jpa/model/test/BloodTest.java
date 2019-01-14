package ua.bondarenkojek.homework.jpa.model.test;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class BloodTest extends Test {
    private Double glucose;

    @Override
    public Double getResult() {
        return glucose;
    }

    @Override
    public void setResult(Double result) {
        glucose = result;
    }
}
