package ua.bondarenkojek.homework.jpa.model.test;

import lombok.Data;
import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.util.ResultTest;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "skin_test")
public class SkinTest extends Test {
    private Double skinProblems;

    @Override
    public Test doTest(Patient patient) {
        super.doTest(patient);
        skinProblems = ResultTest.getResult();
        return this;
    }

    @Override
    public Double getResult() {
        return skinProblems;
    }
}
