package com.test.controller;

import com.test.MyException;
import com.test.po.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by wiseacre on 2018/8/12.
 */
@RestController
public class UserController {

    @RequestMapping("/test")
    public Object crateUser(@Validated @RequestBody User user, BindingResult bindingResult){
        return "OK";
    }
/*
    @ExceptionHandler(value={MyException.class})
    public String testException(Exception ex){

        return ex.toString();
    }*/

}
