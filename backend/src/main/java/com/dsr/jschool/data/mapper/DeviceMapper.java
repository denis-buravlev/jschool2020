package com.dsr.jschool.data.mapper;

import com.dsr.jschool.data.dto.DeviceDto;
import com.dsr.jschool.data.entity.Device;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeviceMapper {
    public DeviceDto toDeviceDto(Device device) {
        return new DeviceDto(
                device.getId(),
                device.getName(),
                device.getDescription()
        );
    }

    public List<DeviceDto> toDeviceDto(List<Device> devices) {
        return devices.stream()
                .map(this::toDeviceDto)
                .collect(Collectors.toList());
    }
}
