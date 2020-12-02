package com.dsr.jschool.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandlerController {

//    @ExceptionHandler(RuntimeException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public MsgDto runtimeExceptionHandler(RuntimeException e) {
//        return new MsgDto(e.getMessage());
//    }
}
