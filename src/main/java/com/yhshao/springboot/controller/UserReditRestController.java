package com.yhshao.springboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shaoqi on 18/1/17.
 */
@RestController
public class UserReditRestController {


    @RequestMapping("/userredit/{id}")
    public Integer getLevel(@PathVariable String id){
        return Integer.parseInt(id);

    }


}
