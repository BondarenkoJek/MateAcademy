package ua.bondarenkojek.homework.jpa.service;

import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.model.device.Device;
import ua.bondarenkojek.homework.jpa.model.test.Test;

public interface DeviceService {
    Device addDevice(Device device);

    Device getDevice(Long id);

    void updateDevice(Device device);

    void deleteDevice(Device device);

    void doTest(Test test, Patient patient);
}
