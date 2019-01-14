package ua.bondarenkojek.homework.jpa.model.test;

import lombok.Data;
import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.util.ResultTest;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "blood_test")
public class BloodTest extends Test {
    private Double glucose;

    @Override
    public Test doTest(Patient patient) {
        super.doTest(patient);
        glucose = ResultTest.getResult();
        return this;
    }

    @Override
    public Double getResult() {
        return glucose;
    }
}
