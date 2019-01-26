package com.iwbz.exceptiondemo.controller;

import com.iwbz.exceptiondemo.exception.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ExceptionController {

    //只为了demo演示错误才对num进行为空的处理
    @GetMapping("/test1")
    public String test1(Integer num){
        if (num == null){
            throw new CustomException(400,"num不能为空");
        }
        int i = 10 / num;
        return "result:" + i;
    }
}
