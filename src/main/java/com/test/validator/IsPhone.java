package com.test.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by wiseacre on 2018/8/12.
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
//注解的实现类。
@Constraint(validatedBy = {IsPhoneValidator.class})
public @interface IsPhone {
    String message() default "参数格式错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String code() default "NOT_VALID";

}
