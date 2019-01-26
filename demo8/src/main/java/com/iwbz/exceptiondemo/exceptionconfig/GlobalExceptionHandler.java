package com.iwbz.exceptiondemo.exceptionconfig;

import com.iwbz.exceptiondemo.exception.CustomException;
import com.iwbz.exceptiondemo.exceptionentity.ErrorResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;

//异常处理配置类
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    //定义要捕获的异常
    @ExceptionHandler(CustomException.class)
    public ErrorResponseEntity customExceptionHandler(HttpServletResponse response
            , final Exception e, HttpServletRequest request){

        response.setStatus(HttpStatus.BAD_REQUEST.value());
        CustomException exception = (CustomException) e;
        return new ErrorResponseEntity(exception.getCode(),exception.getMessage());
    }

    //捕获runtimeexception
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseEntity runtimeExceptionHandler(HttpServletResponse response
            , final Exception e, HttpServletRequest request){
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        RuntimeException exception = (RuntimeException) e;
        return new ErrorResponseEntity(400,exception.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body
            , HttpHeaders headers, HttpStatus status, WebRequest request) {

        //参数无效
        if (ex instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            return new ResponseEntity<>(new ErrorResponseEntity(status.value(),
                    exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()),status);
        }

        //参数转换失败
        if (ex instanceof MethodArgumentTypeMismatchException){
            MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
            logger.error("参数转换失败，方法："+exception.getParameter().getMethod().getName()
                    +",参数："+exception.getName()+",信息："+exception.getLocalizedMessage());
            return new ResponseEntity<>(new ErrorResponseEntity(status.value(),
                    "参数转换失败"),status);
        }
        return new ResponseEntity<>(new ErrorResponseEntity(status.value(),
                "参数转换失败"),status);
    }
}
