package com.suchness.intellisense.common.exception;

import com.suchness.intellisense.common.api.IErrorCode;

/***
 *  author: rushi
 *  create_time : 2020/11/2510:14
 *******/
public class ApiException extends RuntimeException{

    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
