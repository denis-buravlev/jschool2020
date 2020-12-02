package com.dsr.jschool.data.mapper.impl;

import com.dsr.jschool.data.dto.device.DeviceDto;
import com.dsr.jschool.data.entity.Device;
import com.dsr.jschool.data.mapper.BaseObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class DeviceToDeviceDtoObjectMapper extends BaseObjectMapper<Device, DeviceDto> {

    private final UserToUserDtoObjectMapper userMapper;

    public DeviceToDeviceDtoObjectMapper(UserToUserDtoObjectMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public DeviceDto convert(Device obj) {
        var owner = userMapper.convert(obj.getOwner());

        return new DeviceDto(
                obj.getId(),
                obj.getName(),
                obj.getDescription(),
                owner
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
