package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.MsgDto;
import com.dsr.jschool.service.AnimalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    private final AnimalService animalService;

    public TestController(
            AnimalService animalService
    ) {
        this.animalService = animalService;
    }

    @RequestMapping(method = GET, path = "/animal")
    public MsgDto getCat() {
        return new MsgDto(animalService.say());
    }
}