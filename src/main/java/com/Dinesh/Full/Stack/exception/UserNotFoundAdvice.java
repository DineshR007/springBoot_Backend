package com.Dinesh.Full.Stack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(UserNotFoundExeception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> execeptionHandler (UserNotFoundExeception exeception) {
        Map<String,String> errorMap = new HashMap<>();
                errorMap.put("errorMessage",exeception.getMessage());
        return errorMap;
    }

}
