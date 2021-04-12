package com.suchness.intellisense.common.exception;

import com.suchness.intellisense.common.api.IErrorCode;

/***
 *  author: rushi
 *  create_time : 2020/11/2510:12
 *******/
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
