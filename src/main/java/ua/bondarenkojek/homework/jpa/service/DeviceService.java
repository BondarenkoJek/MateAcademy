package ua.bondarenkojek.homework.jpa.service;

import ua.bondarenkojek.homework.jpa.model.device.Device;

public interface DeviceService {
    Long createDevice(Device device);

    Device readDevice(Long id);

    void updateDevice(Device device);

    void deleteDevice(Device device);
}
