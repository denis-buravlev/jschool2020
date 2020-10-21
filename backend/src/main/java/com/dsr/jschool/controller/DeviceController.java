package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.MsgDto;
import com.dsr.jschool.service.DeviceService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/v1/devices")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(
            DeviceService deviceService
    ) {
        this.deviceService = deviceService;
    }

    @RequestMapping(method = GET, path = "/")
    public MsgDto getDevices() {
        return new MsgDto("");
    }

    @RequestMapping(method = GET, path = "/:id")
    public MsgDto getDevice() {
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