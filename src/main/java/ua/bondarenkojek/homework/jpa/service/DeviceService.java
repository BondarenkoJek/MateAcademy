package ua.bondarenkojek.homework.jpa.service;

import ua.bondarenkojek.homework.jpa.model.device.Device;

public interface DeviceService {
    Device addDevice(Device device);

    Device getDevice(Long id);

    void updateDevice(Device device);

    void deleteDevice(Device device);
}
