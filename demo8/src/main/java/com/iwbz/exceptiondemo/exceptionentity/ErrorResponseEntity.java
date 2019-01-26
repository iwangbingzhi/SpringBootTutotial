package com.iwbz.exceptiondemo.exceptionentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseEntity {
    private int code;
    private String message;

}
