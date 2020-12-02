package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.MsgDto;
import com.dsr.jschool.data.mapper.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/v1/me")
public class CurrentUserController {

    private final Mapper mapper;

    public CurrentUserController(
            Mapper mapper
    ) {
        this.mapper = mapper;
    }

    @RequestMapping(method = GET, path = "")
    public MsgDto getProfile() {
        return new MsgDto("");
    }

    @RequestMapping(method = GET, path = "/devices")
    public MsgDto getDevices(Long id) {
        return new MsgDto("");
    }
}