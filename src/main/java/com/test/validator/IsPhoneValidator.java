package com.test.validator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Created by wiseacre on 2018/8/12.
 */
public class IsPhoneValidator implements ConstraintValidator<IsPhone, String>{
    private String code;

    private static final Pattern moble_pattern = Pattern.compile("1\\d{10}");
    @Override
    public void initialize(IsPhone IsPhone) {
        this.code = IsPhone.code();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return isPhoneNumber(s);
    }

    private boolean isPhoneNumber(String s){
        if(StringUtils.isEmpty(s)){
            return false;
        }
        return moble_pattern.matcher(s).matches();
    }
}
