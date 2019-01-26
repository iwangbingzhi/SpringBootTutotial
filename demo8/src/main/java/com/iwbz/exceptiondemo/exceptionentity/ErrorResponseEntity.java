package com.iwbz.exceptiondemo.exceptionentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//异常处理模板实体
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseEntity {
    private int code;
    private String message;

}
