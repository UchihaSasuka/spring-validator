package com.test.po;

import com.test.validator.IsPhone;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by wiseacre on 2018/8/12.
 */

@Data
public class User {

    @NotNull
    @Size(min = 5, max = 30, message = "400|姓名长度必须在5~30之间")
    private String name;

    @NotNull
    @Min(18)
    private int age;

    @NotNull(message = "手机号码不允许为空")
    @IsPhone(message = "400|错误的手机号码格式")
    private String phoneNumber;
}
