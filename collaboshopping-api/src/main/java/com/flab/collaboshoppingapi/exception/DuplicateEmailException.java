package com.flab.collaboshoppingapi.exception;

import lombok.Getter;

@Getter
public class DuplicateEmailException extends RuntimeException{

    private ErrorCode errorCode;

    public DuplicateEmailException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
