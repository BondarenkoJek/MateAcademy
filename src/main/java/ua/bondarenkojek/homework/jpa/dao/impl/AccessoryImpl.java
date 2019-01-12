package ua.bondarenkojek.homework.jpa.dao.impl;

import ua.bondarenkojek.homework.jpa.dao.AbstractDao;
import ua.bondarenkojek.homework.jpa.dao.Accessory;

import javax.persistence.EntityManager;

public class AccessoryImpl extends AbstractDao implements Accessory {
    public AccessoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Long createEntity(Accessory entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return (Long) entityManager
                .createQuery("select a.id from accessory a order by a.id desc")
                .setMaxResults(1)
                .getSingleResult();
    }

    @Override
    public Accessory readEntity(Long id) {
        entityManager.getTransaction().begin();
        Accessory accessory = entityManager.find(Accessory.class, id);
        entityManager.getTransaction().commit();
        return accessory;
    }

    @Override
    public void updateEntity(Accessory entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteEntity(Accessory entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
