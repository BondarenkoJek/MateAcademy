package ua.bondarenkojek.homework.jpa.dao;

import javax.persistence.EntityManager;

public abstract class AbstractDao {
    protected EntityManager entityManager;

    public AbstractDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
