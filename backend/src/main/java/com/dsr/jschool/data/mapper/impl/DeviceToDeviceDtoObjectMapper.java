package com.dsr.jschool.data.mapper.impl;

import com.dsr.jschool.data.dto.DeviceDto;
import com.dsr.jschool.data.entity.Device;
import com.dsr.jschool.data.mapper.BaseObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class DeviceToDeviceDtoObjectMapper extends BaseObjectMapper<Device, DeviceDto> {

    @Override
    public DeviceDto convert(Device obj) {
        return new DeviceDto(
                obj.getId(),
                obj.getName(),
                obj.getDescription()
        );
    }

    @Override
    public Class<Device> getInClass() {
        return Device.class;
    }

    @Override
    public Class<DeviceDto> getOutClass() {
        return DeviceDto.class;
    }
}
