package ua.bondarenkojek.homework.jpa.service.impl;

import ua.bondarenkojek.homework.jpa.dao.TestDao;
import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.model.test.Test;
import ua.bondarenkojek.homework.jpa.service.TestService;

import java.time.LocalDate;
import java.util.List;

public class TestServiceImpl implements TestService {
    private TestDao testDao;

    public TestServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public Long createTest(Test test) {
        return testDao.createEntity(test);
    }

    @Override
    public Test readTest(Long id) {
        return testDao.read(id);
    }

    @Override
    public void updateTest(Test test) {
        testDao.update(test);
    }

    @Override
    public void deleteTest(Test test) {
        testDao.delete(test);
    }

    @Override
    public List<Test> getAllTests() {
        return testDao.getAllTests();
    }

    @Override
    public List<Test> getAllTestsInDateRange(LocalDate from, LocalDate to) {
        return testDao.getAllTestsInDateRange(from, to);
    }

    @Override
    public List<Patient> getPatientsWithGlucoseHigherThan(Double normalLevel) {
        return testDao.getPatientsWithGlucoseHigherThan(normalLevel);
    }
}
