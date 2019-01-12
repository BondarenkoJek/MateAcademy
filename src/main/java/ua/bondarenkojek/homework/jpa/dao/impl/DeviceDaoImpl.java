package ua.bondarenkojek.homework.jpa.dao.impl;

import ua.bondarenkojek.homework.jpa.dao.AbstractDao;
import ua.bondarenkojek.homework.jpa.dao.DeviceDao;
import ua.bondarenkojek.homework.jpa.model.device.Device;

import javax.persistence.EntityManager;

public class DeviceDaoImpl extends AbstractDao implements DeviceDao {
    public DeviceDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Long createEntity(Device entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return (Long) entityManager
                .createQuery("select d.id from device d order by d.id desc")
                .setMaxResults(1)
                .getSingleResult();
    }

    @Override
    public Device readEntity(Long id) {
        entityManager.getTransaction().begin();
        Device device = entityManager.find(Device.class, id);
        entityManager.getTransaction().commit();
        return device;
    }

    @Override
    public void updateEntity(Device entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteEntity(Device entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
