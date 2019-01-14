package ua.bondarenkojek.homework.jpa.dao.impl;

import ua.bondarenkojek.homework.jpa.dao.AbstractDao;
import ua.bondarenkojek.homework.jpa.dao.AccessoryDao;
import ua.bondarenkojek.homework.jpa.model.accessory.Accessory;

import javax.persistence.EntityManager;

public class AccessoryDaoImpl extends AbstractDao<Accessory, Long> implements AccessoryDao {
    public AccessoryDaoImpl(EntityManager entityManager) {
        super(entityManager, Accessory.class);
    }
}
