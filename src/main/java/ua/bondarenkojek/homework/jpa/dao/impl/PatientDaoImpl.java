package ua.bondarenkojek.homework.jpa.dao.impl;

import ua.bondarenkojek.homework.jpa.dao.AbstractDao;
import ua.bondarenkojek.homework.jpa.dao.PatientDao;
import ua.bondarenkojek.homework.jpa.model.Patient;

import javax.persistence.EntityManager;

public class PatientDaoImpl extends AbstractDao<Patient, Long> implements PatientDao {
    public PatientDaoImpl(EntityManager entityManager) {
        super(entityManager, Patient.class);
    }
}
