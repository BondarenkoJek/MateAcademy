package ua.bondarenkojek.homework.jpa.dao.impl;

import ua.bondarenkojek.homework.jpa.dao.AbstractDao;
import ua.bondarenkojek.homework.jpa.dao.PatientDao;
import ua.bondarenkojek.homework.jpa.model.Patient;

import javax.persistence.EntityManager;

public class PatientDaoImpl extends AbstractDao implements PatientDao {
    public PatientDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Long createEntity(Patient entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return (Long) entityManager.createQuery("select p.id from patient p order by p.id desc").setMaxResults(1).getSingleResult();
    }

    @Override
    public Patient readEntity(Long id) {
        entityManager.getTransaction().begin();
        Patient patient = entityManager.find(Patient.class, id);
        entityManager.getTransaction().commit();
        return patient;
    }

    @Override
    public void updateEntity(Patient entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteEntity(Patient entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
