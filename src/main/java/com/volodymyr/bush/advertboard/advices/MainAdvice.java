package com.volodymyr.bush.advertboard.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MainAdvice {

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String exceptionHandler(RuntimeException ex) {
        return ex.getMessage();
    }
}
