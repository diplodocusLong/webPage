package com.bohui.wf.gps.website.webpage.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


/**
 * @author lianglong
 * @date 2019/10/8
 */
@Data
@Accessors(chain = true)
public class Result {

    /**
     * 请求是否成功
     */
    private boolean success;
    /**
     * 成功或者失败的code错误码
     */
    private String code;
    /**
     * 成功时返回的数据，失败时返回具体的异常信息
     */
    private Object data;
    /**
     * 请求失败返回的提示信息，给前端进行页面展示的信息
     */
    private Object message;

    /**
     * 当前时间
     * @return
     */
    private LocalDateTime time;

    public static Result OK() {

        return new Result()
                .setSuccess(true)
                .setCode(ResultDes.SUCCESS.getCode())
                .setMessage(ResultDes.SUCCESS.getMessage())
                .setTime(LocalDateTime.now());
    }

    public static Result ERROR(ResultDes des){

         return  new Result()
                 .setSuccess(false)
                 .setCode(des.getCode())
                 .setMessage(des.getMessage())
                 .setTime(LocalDateTime.now());
    }

}
