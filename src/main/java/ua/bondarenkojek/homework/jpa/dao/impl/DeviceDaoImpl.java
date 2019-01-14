package ua.bondarenkojek.homework.jpa.dao.impl;

import ua.bondarenkojek.homework.jpa.dao.AbstractDao;
import ua.bondarenkojek.homework.jpa.dao.DeviceDao;
import ua.bondarenkojek.homework.jpa.model.device.Device;

import javax.persistence.EntityManager;

public class DeviceDaoImpl extends AbstractDao<Device, Long> implements DeviceDao {
    public DeviceDaoImpl(EntityManager entityManager) {
        super(entityManager, Device.class);
    }
}
