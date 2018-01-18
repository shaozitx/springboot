package com.yhshao.springboot.controller;

import com.yhshao.springboot.entity.User;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by shaoqi on 18/1/17.
 */
@RestController
public class UserReditRestController {


    @RequestMapping("/userredit/{id}")
    public Integer getLevel(@PathVariable String id){
        return Integer.parseInt(id);

    }

    @PostMapping("register")
    public void registerUser(@Validated User user , BindingResult result){

        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            FieldError error = (FieldError) list.get(0);
            System.out.println(error.getObjectName() + ","+error.getField()+ ","+ error.getDefaultMessage());
            return;
        }

        System.out.printf(user.getName() +"and userpass" + user.getPassword() );

        return;
    }


}
