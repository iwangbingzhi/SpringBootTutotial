package com.iwbz.exceptiondemo.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 45654646518647643L;

    private int code;

    public CustomException() {
        super();
    }

    public CustomException(int code,String message) {
        super(message);
        this.setCode(code);
    }
}
