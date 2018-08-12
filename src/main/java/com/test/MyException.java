package com.test;

/**
 * Created by wiseacre on 2018/8/12.
 */
public class MyException extends RuntimeException{

    private String code;

    public MyException(String code, String message, Throwable cause){
        super(message, cause);
        this.code = code;
    }

    public MyException(String code, String message){
        super(message);
        this.code = code;
    }

    public MyException(String message){
        super(message);
    }

}
