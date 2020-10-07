package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.Test4Dto;
import com.dsr.jschool.data.dto.TestDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @RequestMapping(method = GET, path = "/test")
    public TestDto getTest() {
        throw new RuntimeException("foo bar baz");
        //return new TestDto("Hello!");
    }

    @RequestMapping(method = GET, path = "/test2/{id}")
    public TestDto getTest2(@PathVariable(required = true) Integer id) {
        return new TestDto(id.toString());
    }

    @RequestMapping(method = GET, path = "/test3")
    public TestDto getTest3(@RequestParam(required = true, defaultValue = "0") Integer page) {
        return new TestDto(page.toString());
    }

    @RequestMapping(method = POST, path = "/test4")
    public TestDto getTest4(@RequestBody Test4Dto dto) {
        return new TestDto(dto.getName() + " " + dto.getAge());
    }
}
