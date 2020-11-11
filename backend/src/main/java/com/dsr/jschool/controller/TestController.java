package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.DeviceWithOwnerDto;
import com.dsr.jschool.data.dto.UserDto;
import com.dsr.jschool.data.entity.User;
import com.dsr.jschool.data.repository.DeviceRepository;
import com.dsr.jschool.data.repository.RoleRepository;
import com.dsr.jschool.data.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/test")
public class TestController {

    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public TestController(
            DeviceRepository deviceRepository,
            UserRepository userRepository, RoleRepository roleRepository) {
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @RequestMapping(method = GET, path = "/user")
    public User user() {
        // TODO: HomeWork
        return userRepository.findByName("user1");
    }

    @RequestMapping(method = GET, path = "/device")
    public List<DeviceWithOwnerDto> device() {
        var devices = deviceRepository.findByName("firstDevice");
        var result = new ArrayList<DeviceWithOwnerDto>();
        devices.forEach((device) -> {
            var dto = new DeviceWithOwnerDto();
            dto.setId(device.getId());
            dto.setName(device.getName());
            dto.setDescription(device.getDescription());

            var ownerDto = new UserDto();
            ownerDto.setId(device.getOwner().getId());
            ownerDto.setName(device.getOwner().getName());

            dto.setOwner(ownerDto);
            result.add(dto);
        });
        return result;
    }

    @RequestMapping(method = GET, path = "/user-roles")
    public List<String> roles() {
        return userRepository.findByName("user1")
                .getRoles()
                .stream()
                .map((role) -> {
                    return "ID: " + role.getId() + " Name: " + role.getName();
                }).collect(Collectors.toList());
    }

}