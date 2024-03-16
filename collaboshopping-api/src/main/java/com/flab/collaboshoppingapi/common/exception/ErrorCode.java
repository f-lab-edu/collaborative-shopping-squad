package com.flab.collaboshoppingapi.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND(404,"COMMON-ERR-404","PAGE NOT FOUND"),
    INTER_SERVER_ERROR(500,"COMMON-ERR-500","INTER SERVER ERROR"),
    EMAIL_DUPLICATION(400,"MEMBER-ERR-C001","EMAIL DUPLICATED"),
    EMAIL_NOT_EXIST(400,"MEMBER-ERR-C002","EMAIL NOT EXIST"),
    WRONG_PASSWORD(400,"MEMBER-ERR-C003","WRONG PASSWORD"),
    ;

    private int status;
    private String errorCode;
    private String message;
}