package com.yhshao.springboot.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yhshao.springboot.entity.User;
import com.yhshao.springboot.service.UserService;
import com.yhshao.springboot.service.UserServiceImpl;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * Created by shaoqi on 18/1/17.
 */
@Controller
public class UserReditRestController {


    @Autowired ObjectMapper objectMapper;


    @Autowired UserService userService;

    @RequestMapping("/jsonparse")
    public @ResponseBody String parser() throws JsonParseException, IOException{

        String json = "{\"name\":\"lilie\",\"id\":10}";

        JsonFactory f = objectMapper.getFactory();
        JsonParser parser = f.createParser(json);
        String key = null ,value = null;

        JsonToken token = parser.nextToken();

        token = parser.nextToken();
        if (token == JsonToken.FIELD_NAME){
            key = parser.getCurrentName();
        }
        token = parser.nextToken();
        value = parser.getValueAsString();
        parser.close();
        return key + "," + value;

    }


    @RequestMapping("/userinfo/{id}")
    public @ResponseBody User getLevel(@PathVariable String id){

        User user = userService.getUserById(Integer.parseInt(id));
        return user;

    }

    @RequestMapping("register")
    public @ResponseBody User registerUser(@Validated User user , BindingResult result){

        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            FieldError error = (FieldError) list.get(0);
            System.out.println(error.getObjectName() + ","+error.getField()+ ","+ error.getDefaultMessage());
            return user;
        }

        System.out.println("name :" + user.getName() +" and pass:");

        return user;
    }

    @RequestMapping("/index")
    public ModelAndView index( ){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.html");
        return modelAndView;


    }



}
