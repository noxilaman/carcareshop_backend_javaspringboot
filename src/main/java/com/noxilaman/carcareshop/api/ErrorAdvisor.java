package com.noxilaman.carcareshop.api;

import com.noxilaman.carcareshop.exception.BaseException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorAdvisor {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException e){
        ErrorResponse res = new ErrorResponse();
        res.setError(e.getMessage());
        res.setStatus(HttpStatus.EXPECTATION_FAILED.value());
        return new ResponseEntity<>(res,HttpStatus.EXPECTATION_FAILED);
    }

    @Data
    public static class ErrorResponse{

        private LocalDateTime timestamp = LocalDateTime.now();
        private int status;
        private String error;


    }
}
