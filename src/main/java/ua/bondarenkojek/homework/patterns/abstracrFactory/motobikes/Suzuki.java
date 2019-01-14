package ua.bondarenkojek.homework.patterns.abstracrFactory.motobikes;

import java.time.LocalDate;

public class Suzuki implements Motorbike {
    private String name;
    private String model;
    private LocalDate dateOfMade;

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDateOfMade(LocalDate dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public LocalDate getDateOfMade() {
        return dateOfMade;
    }
}
