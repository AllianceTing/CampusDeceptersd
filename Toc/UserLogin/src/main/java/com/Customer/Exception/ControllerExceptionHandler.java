package com.Customer.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Hashtable;
import java.util.Map;


@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RespRuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleMyRuntimeException(RespRuntimeException ex) {
        Map<String, Object> result = new Hashtable<>();
        result.put("id", ex.getId());
        result.put("msg", ex.getMessage());
        return result;
    }

}
