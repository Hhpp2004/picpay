package com.example.picpay.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.picpay.Exception.PicpayExe;

@RestControllerAdvice
public class RestExeceptionHandler {
    @ExceptionHandler(PicpayExe.class)
    public ProblemDetail handlePicPayExeception(PicpayExe e)
    {
        return e.toProblemDetail();
    }    

    private record InvalidParam(String fieldnome, String reason) {

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
    {   
        var fielderros = e.getFieldErrors().stream()
            .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
            .toList();
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("400 - Your Request parameters didn't validate");
        pb.setProperty("invalid-params",fielderros);
        return pb;
    }

}
