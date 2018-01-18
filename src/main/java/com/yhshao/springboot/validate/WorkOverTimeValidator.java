package com.yhshao.springboot.validate;

import com.yhshao.springboot.anotation.WorkOverTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by shaoqi on 18/1/18.
 */
public class WorkOverTimeValidator implements ConstraintValidator<WorkOverTime,Integer> {



    WorkOverTime work;
    int max;
    public void initialize(WorkOverTime work){

        this.work = work;
        max = work.max();

    }

    public boolean isValid(Integer value, ConstraintValidatorContext context){

        if (value==null)
            return true;
        return value<max;

    }



}
