package com.flab.collaboshoppingapi.common.exception;

import lombok.Getter;

@Getter
public class NotExistEmailException extends RuntimeException{

    private ErrorCode errorCode;

    public NotExistEmailException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
