package ua.bondarenkojek.homework.jpa.dao;

import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.model.test.Test;

import java.time.LocalDate;
import java.util.List;

public interface TestDao extends CrudDao<Test> {
    List<Test> getAllTests();

    List<Test> getAllTestsInDateRange(LocalDate from, LocalDate to);

    List<Patient> getPatientsWithGlucoseHigherThan(Double normalLevel);
}
