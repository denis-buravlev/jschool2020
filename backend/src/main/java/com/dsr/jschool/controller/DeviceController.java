package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.device.CreateOrUpdateDeviceDto;
import com.dsr.jschool.data.dto.device.DeviceDto;
import com.dsr.jschool.data.dto.device.TransferDeviceDto;
import com.dsr.jschool.data.entity.Device;
import com.dsr.jschool.data.mapper.Mapper;
import com.dsr.jschool.service.DeviceService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/v1/devices")
public class DeviceController {

    private final DeviceService deviceService;
    private final Mapper mapper;

    public DeviceController(
            DeviceService deviceService,
            Mapper mapper
    ) {
        this.deviceService = deviceService;
        this.mapper = mapper;
    }

    @RequestMapping(method = GET, path = "")
    public List<DeviceDto> getDevices() {
        return mapper.convertList(deviceService.getAllDevices(), DeviceDto.class);
    }

    @RequestMapping(method = GET, path = "/{id}")
    public DeviceDto getDevice(@PathVariable Long id) {
        var device = deviceService.findById(id);
        return mapper.convert(device, DeviceDto.class);
    }

    @RequestMapping(method = POST, path = "")
    public DeviceDto createDevice(@RequestBody CreateOrUpdateDeviceDto dto) {
        var createdDevice = deviceService.createOrUpdateDevice(mapper.convert(dto, Device.class));
        return mapper.convert(createdDevice, DeviceDto.class);
    }

    @RequestMapping(method = PUT, path = "/{id}")
    public DeviceDto updateDevice(
            @PathVariable Long id,
            @RequestBody CreateOrUpdateDeviceDto dto
    ) {
        var device = deviceService.findById(id);

        device.setName(dto.getName());
        device.setDescription(dto.getDescription());

        var updatedDevice = deviceService.createOrUpdateDevice(device);

        return mapper.convert(updatedDevice, DeviceDto.class);
    }

    @RequestMapping(method = DELETE, path = "/{id}")
    public void deleteDevice(@PathVariable Long id) {
        deviceService.deleteDeviceById(id);
    }

    @RequestMapping(method = POST, path = "/{id}/transfer")
    public DeviceDto transferDevice(
            @PathVariable Long id,
            @RequestBody TransferDeviceDto dto
    ) {
        return mapper.convert(deviceService.transferDeviceToUserById(id, dto.getToUser()), DeviceDto.class);
    }
}