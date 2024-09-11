package com.supercoding.mall_jpa.exceptions;

public class UserSignUpFailException extends RuntimeException{

    public UserSignUpFailException(String message) {
        super(message);
    }
}
