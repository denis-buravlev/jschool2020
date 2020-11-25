package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.DeviceDto;
import com.dsr.jschool.data.dto.MsgDto;
import com.dsr.jschool.data.mapper.DeviceMapper;
import com.dsr.jschool.data.mapper.Mapper;
import com.dsr.jschool.service.DeviceService;
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
            DeviceMapper deviceMapper,
            Mapper mapper) {
        this.deviceService = deviceService;
        this.mapper = mapper;
    }

    @RequestMapping(method = GET, path = "")
    public List<DeviceDto> getDevices() {
        return mapper.convertList(deviceService.getAllDevices(), DeviceDto.class);
    }

    @RequestMapping(method = GET, path = "/:id")
    public MsgDto getDevice(Long id) {
        return new MsgDto("");
    }

    @RequestMapping(method = POST, path = "/")
    public MsgDto createDevice() {
        return new MsgDto("");
    }

    @RequestMapping(method = PUT, path = "/:id")
    public MsgDto updateDevice() {
        return new MsgDto("");
    }

    @RequestMapping(method = DELETE, path = "/:id")
    public MsgDto deleteDevice() {
        return new MsgDto("");
    }
}