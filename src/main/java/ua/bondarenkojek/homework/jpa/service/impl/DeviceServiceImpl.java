package ua.bondarenkojek.homework.jpa.service.impl;

import ua.bondarenkojek.homework.jpa.dao.DeviceDao;
import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.model.device.Device;
import ua.bondarenkojek.homework.jpa.model.test.Test;
import ua.bondarenkojek.homework.jpa.service.DeviceService;
import ua.bondarenkojek.homework.jpa.util.ResultTest;

import java.time.LocalDate;

public class DeviceServiceImpl implements DeviceService {
    private DeviceDao deviceDao;

    public DeviceServiceImpl(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    @Override
    public Device addDevice(Device device) {
        return deviceDao.create(device);
    }

    @Override
    public Device getDevice(Long id) {
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

    @Override
    public void doTest(Test test, Patient patient) {
        test.setDateOfCreate(LocalDate.now());
        test.setResult(ResultTest.getResult());
        patient.addTest(test);
        addDevice(test.getDevice());
    }
}
