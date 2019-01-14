package ua.bondarenkojek.homework.patterns.abstracrFactory.cars;

import java.time.LocalDate;

public interface Car {
    String getName();
    String getModel();
    LocalDate getDateOfMade();
}
