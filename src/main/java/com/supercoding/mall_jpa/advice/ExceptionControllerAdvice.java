package com.supercoding.mall_jpa.advice;

import com.supercoding.mall_jpa.exceptions.NotFoundException;
import com.supercoding.mall_jpa.exceptions.UserSignUpFailException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserSignUpFailException.class)
    public String handleUserSignUpFailException(UserSignUpFailException e){
        log.error("Client 가 회원가입에 실패했습니다. message: {}",e.getMessage());
        return e.getMessage();
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(NotFoundException e){
        log.error("Client 가 요청한 데이터가 존재하지 않습니다. message: {}",e.getMessage());
        return e.getMessage();
    }
}
