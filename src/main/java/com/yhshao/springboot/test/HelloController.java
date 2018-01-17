package com.yhshao.springboot.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by shaoqi on 18/1/17.
 */

@Controller
public class HelloController {


    @RequestMapping("/hello")
    @ResponseBody
    public String sayhellow(){
        return "hello wordddddld";

    }
}
