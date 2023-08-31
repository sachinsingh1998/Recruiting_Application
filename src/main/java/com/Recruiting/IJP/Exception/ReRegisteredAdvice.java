package com.Recruiting.IJP.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ReRegisteredAdvice {
    @ResponseBody
    @ExceptionHandler(ReRegisteredException.class)
    public Map<String,String> reExceptionHandler(ReRegisteredException reRegisteredException){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("message",reRegisteredException.getMessage());
        return errorMap;
    }
}
