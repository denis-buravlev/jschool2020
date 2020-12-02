package com.dsr.jschool.service;

import com.dsr.jschool.data.entity.Device;
import com.dsr.jschool.data.repository.DeviceRepository;
import com.dsr.jschool.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service()
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final UserService userService;

    public DeviceService(DeviceRepository deviceRepository, UserService userService) {
        this.deviceRepository = deviceRepository;
        this.userService = userService;
    }

    public List<Device> getAllDevices() {
        var result = new ArrayList<Device>();
        deviceRepository.findAll().forEach(result::add);
        return result;
    }

    public Device createOrUpdateDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device findById(Long id) {
        return deviceRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteDeviceById(Long id) {
        var device = findById(id);
        deviceRepository.delete(device);
    }

    @Transactional
    public Device transferDeviceToUserById(Long deviceId, Long userId) {
        var device = findById(deviceId);
        var user = userService.findById(userId);
        device.setOwner(user);
        return createOrUpdateDevice(device);
    }
}
