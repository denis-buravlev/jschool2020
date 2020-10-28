package com.dsr.jschool.controller;

import com.dsr.jschool.data.entity.Device;
import com.dsr.jschool.data.mapper.DeviceMapper;
import com.dsr.jschool.data.repository.DeviceRepository;
import com.dsr.jschool.service.DeviceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/test")
public class TestController {

    private final DeviceService deviceService;
    private final DeviceMapper deviceMapper;
    private final DeviceRepository deviceRepository;

    public TestController(
            DeviceService deviceService,
            DeviceMapper deviceMapper, DeviceRepository deviceRepository) {
        this.deviceService = deviceService;
        this.deviceMapper = deviceMapper;
        this.deviceRepository = deviceRepository;
    }

    @RequestMapping(method = GET, path = "/findByName")
    public List<Device> findByName() {
        return deviceRepository.findByName("firstDevice");
    }

    @RequestMapping(method = GET, path = "/paging")
    public Page<Device> paging() {
        var pageReq = PageRequest.of(0, 2, DESC, "id", "name");
        return deviceRepository.findAll(pageReq);
    }
}