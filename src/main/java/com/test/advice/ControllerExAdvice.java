package com.test.advice;

import com.test.MyException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * Created by wiseacre on 2018/8/12.
 */
@Aspect
@Component
public class ControllerExAdvice {
    @Around("execution(* com.test.controller.*.*(..)) && args(..,bindingResult)")
    public Object doAround(ProceedingJoinPoint pjp, BindingResult bindingResult) throws Throwable {
        Object retVal;
        if (bindingResult.hasErrors()) {
            ObjectError objectError = bindingResult.getAllErrors().get(0);
            String defaultMessage = objectError.getDefaultMessage();
            if(defaultMessage.contains("|")){
                String[] messages = defaultMessage.split("\\|");
                throw new MyException(messages[0], messages[1]);
            }

            throw new MyException("BadRequest", defaultMessage);
        } else {
            retVal = pjp.proceed();
        }
        return retVal;
    }
}
