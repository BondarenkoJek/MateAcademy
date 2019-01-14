package ua.bondarenkojek.homework.jpa.dao.impl;

import ua.bondarenkojek.homework.jpa.dao.AbstractDao;
import ua.bondarenkojek.homework.jpa.dao.TestDao;
import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.model.test.Test;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class TestDaoImpl extends AbstractDao<Test, Long> implements TestDao {
    public TestDaoImpl(EntityManager entityManager) {
        super(entityManager, Test.class);
    }

    @Override
    public List<Test> getAllTests() {
        return entityManager.createQuery("from test", Test.class).getResultList();
    }

    @Override
    public List<Test> getAllTestsInDateRange(LocalDate from, LocalDate to) {
        return entityManager
                .createQuery("select t " +
                        "from test t " +
                        "where t.dateOfCreate >= :frm and t.dateOfCreate <= :to", Test.class)
                .setParameter("frm", from)
                .setParameter("to", to)
                .getResultList();
    }

    @Override
    public List<Patient> getPatientsWithGlucoseHigherThan(Double normalLevel) {
        return entityManager
                .createQuery("select p " +
                        "from Patient p " +
                        "inner join BloodTest b " +
                        "on p.id = b .patient.id " +
                        "where b.glucose > :norma", Patient.class)
                .setParameter("norma", normalLevel)
                .getResultList();
    }
}
