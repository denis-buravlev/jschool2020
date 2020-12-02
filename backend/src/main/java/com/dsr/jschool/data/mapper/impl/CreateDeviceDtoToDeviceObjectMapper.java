package com.dsr.jschool.data.mapper.impl;

import com.dsr.jschool.data.dto.device.CreateOrUpdateDeviceDto;
import com.dsr.jschool.data.entity.Device;
import com.dsr.jschool.data.mapper.BaseObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateDeviceDtoToDeviceObjectMapper extends BaseObjectMapper<CreateOrUpdateDeviceDto, Device> {
    @Override
    public Device convert(CreateOrUpdateDeviceDto obj) {
        var result = new Device();
        result.setName(obj.getName());
        result.setDescription(obj.getDescription());
        return result;
    }

    @Override
    public Class<CreateOrUpdateDeviceDto> getInClass() {
        return CreateOrUpdateDeviceDto.class;
    }

    @Override
    public Class<Device> getOutClass() {
        return Device.class;
    }
}
