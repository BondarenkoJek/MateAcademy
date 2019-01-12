package ua.bondarenkojek.homework.jpa.service;

import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.model.test.Test;

import java.time.LocalDate;
import java.util.List;

public interface TestService {
    Long createTest(Test test);

    Test readTest(Long id);

    void updateTest(Test test);

    void deleteTest(Test test);

    List<Test> getAllTests();

    List<Test> getAllTestsInDateRange(LocalDate from, LocalDate to);

    List<Patient> getPatientsWithGlucoseHigherThan(Double normalLevel);
}
