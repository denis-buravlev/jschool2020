package com.dsr.jschool.service;

import com.dsr.jschool.data.entity.Device;
import com.dsr.jschool.data.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getAllDevices() {
        var result = new ArrayList<Device>();
        deviceRepository.findAll().forEach(result::add);
        return result;
    }

    public Device getDevice(Long id) {
        return deviceRepository.findById(id).orElseThrow();
    }

    public Device createOrUpdateDevice(Device device) {
        return deviceRepository.save(device);
    }
}
