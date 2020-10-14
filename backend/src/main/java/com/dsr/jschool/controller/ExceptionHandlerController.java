package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.MsgDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public MsgDto runtimeExceptionHandler(RuntimeException e) {
        return new MsgDto(e.getMessage());
    }
}
