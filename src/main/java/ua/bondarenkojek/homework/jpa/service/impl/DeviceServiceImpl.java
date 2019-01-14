package ua.bondarenkojek.homework.jpa.service.impl;

import ua.bondarenkojek.homework.jpa.dao.DeviceDao;
import ua.bondarenkojek.homework.jpa.model.device.Device;
import ua.bondarenkojek.homework.jpa.service.DeviceService;

public class DeviceServiceImpl implements DeviceService {
    private DeviceDao deviceDao;

    public DeviceServiceImpl(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    @Override
    public Long createDevice(Device device) {
        return deviceDao.createEntity(device);
    }

    @Override
    public Device readDevice(Long id) {
        return deviceDao.read(id);
    }

    @Override
    public void updateDevice(Device device) {
        deviceDao.update(device);
    }

    @Override
    public void deleteDevice(Device device) {
        deviceDao.delete(device);
    }
}
