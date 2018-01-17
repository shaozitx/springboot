package com.yhshao.springboot.test;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;

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
