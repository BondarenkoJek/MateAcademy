package ua.bondarenkojek.homework.jpa.model.test;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class SkinTest extends Test {
    private Double skinProblems;

    @Override
    public Double getResult() {
        return skinProblems;
    }

    @Override
    public void setResult(Double result) {
        skinProblems = result;
    }
}
