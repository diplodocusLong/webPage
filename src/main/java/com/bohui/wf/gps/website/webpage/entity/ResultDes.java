package com.bohui.wf.gps.website.webpage.entity;


public enum ResultDes {

    SUCCESS("200","成功"),

    ERROE("2001","系统错误"),

    RUNTIMEEXCEPTION("2002","运行时异常");

    private String code;

    private String message;

     ResultDes(String code,String message){
        this.code = code;
        this.message= message;
    }

    public String getCode(){
         return this.code;
    }
    public String getMessage(){
         return this.message;
    }
}
