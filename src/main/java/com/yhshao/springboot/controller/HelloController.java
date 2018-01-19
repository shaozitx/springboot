package com.yhshao.springboot.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yhshao.springboot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shaoqi on 18/1/17.
 */

@Controller
public class HelloController {


    @RequestMapping("/hello")
    @ResponseBody
    public String sayhellow(){
        return "hello world";

    }

    @RequestMapping("/getuser")
    public ModelAndView showuserinfo(){

        System.out.println("---------------");
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setId(1);
        user.setName("yh");
        user.setPassword("111");
        modelAndView.addObject("user",user);
        modelAndView.setViewName("/userInfo");
        return modelAndView;
    }

    @RequestMapping("/getuserj")
    public @ResponseBody User showuserinfo1(){
        User user = new User();
        user.setId(1);
        user.setName("yh");
        user.setPassword("111");
        return user;
    }


    @GetMapping("/getnow")
    public @ResponseBody Map gettime(){
        HashMap map = new HashMap();
        map.put("time",new Date());
        return map;
    }


}
