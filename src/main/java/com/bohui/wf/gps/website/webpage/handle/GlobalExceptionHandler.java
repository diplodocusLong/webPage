package com.bohui.wf.gps.website.webpage.handle;

import com.bohui.wf.gps.website.webpage.entity.Result;
import com.bohui.wf.gps.website.webpage.entity.ResultDes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * @author lianglong
 * @date 2019/10/10
 */

@ControllerAdvice
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public Result nullPointerExceptionHandler(NullPointerException ex) {
        return Result.ERROR(ResultDes.NULLPOINT).setData(ex.getMessage());
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public Result classCastExceptionHandler(ClassCastException ex) {
        return Result.ERROR(ResultDes.CLASSCAST).setData(ex.getMessage());
    }


    //IO异常
    @ExceptionHandler(IOException.class)
    public Result iOExceptionHandler(IOException ex) {
        return Result.ERROR(ResultDes.IO).setData(ex.getMessage());
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Result indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return Result.ERROR(ResultDes.OUTOFBOUND).setData(ex.getMessage());
    }



    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    public Result runtimeExceptionHandler(RuntimeException ex) {
        return Result.ERROR(ResultDes.RUNTIMEEXCEPTION).setData(ex.getMessage());
    }


    @ExceptionHandler(value = Exception.class)
    public Result defaultErrorHandler(Exception ex){

        log.info(ex.getMessage());
        ex.printStackTrace();

        return Result.ERROR(ResultDes.ERROE).setData(ex.getMessage());
    }

}
