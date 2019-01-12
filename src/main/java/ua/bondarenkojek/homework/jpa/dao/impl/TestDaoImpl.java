package ua.bondarenkojek.homework.jpa.dao.impl;

import ua.bondarenkojek.homework.jpa.dao.AbstractDao;
import ua.bondarenkojek.homework.jpa.dao.TestDao;
import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.model.test.Test;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class TestDaoImpl extends AbstractDao implements TestDao {
    public TestDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Long createEntity(Test entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return (Long) entityManager
                .createQuery("select t.id from test t order by t.id desc")
                .setMaxResults(1)
                .getSingleResult();
    }

    @Override
    public Test readEntity(Long id) {
        entityManager.getTransaction().begin();
        Test test = entityManager.find(Test.class, id);
        entityManager.getTransaction().commit();
        return test;
    }

    @Override
    public void updateEntity(Test entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteEntity(Test entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
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
                        "from patient p " +
                        "inner join blood_test b " +
                        "on p.id = b .owner.id " +
                        "where b.glucose > :norma", Patient.class)
                .setParameter("norma", normalLevel)
                .getResultList();
    }
}
