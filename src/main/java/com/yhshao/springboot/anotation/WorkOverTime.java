package com.yhshao.springboot.anotation;


import com.yhshao.springboot.validate.WorkOverTimeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by shaoqi on 18/1/18.
 */
@Constraint(validatedBy = WorkOverTimeValidator.class)  // 这个类用来实现验证
@Documented
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WorkOverTime {

    String message() default "加班时间过长,不超过{max}小时";
    int max() default  5;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
