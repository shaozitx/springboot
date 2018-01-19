package com.yhshao.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

/**
 * Created by shaoqi on 18/1/18.
 */
@Controller
public class ErrorController extends AbstractErrorController {

    Log log = LogFactory.getLog(ErrorController.class);

    @Autowired
    ObjectMapper objectMapper;

    public ErrorController(){

        super(new DefaultErrorAttributes());
    }

    public String getErrorPath(){
        return null;
    }
    @RequestMapping("/error")
    public ModelAndView getErrorPath(HttpServletRequest request, HttpServletResponse response){

        Map<String ,Object> model = Collections.unmodifiableMap(getErrorAttributes(request,false));
        // 获取异常,有可能为空
        Throwable cause = getCause(request);
        int status = (Integer)model.get("status");
        String message = (String) model.get("message");
        String errorMessage = getErrorMessage(cause);

        // 后台打印错误信息
        log.info(status + "," + message + "," + cause);

        response.setStatus(status);
        if (!isJsonRequest(request)){
            // 模板显示错误信息
        }else {
            // 显示错误的json提示
            return null;
        }


        //异常处理
        return new ModelAndView();

    }


    protected Throwable getCause(HttpServletRequest request){
        Throwable error = (Throwable)request.getAttribute("javax.servlet.error.exception");

        if (error != null) {
            while (error instanceof ServletException && error.getCause() != null){
                error = ((ServletException)error).getCause();
            }

        }

        return error;
    }


    protected String getErrorMessage(Throwable ex){


        return "服务器错误,请联系管理员";
    }


    protected boolean isJsonRequest(HttpServletRequest request){

        String requstUrl = (String)request.getAttribute("javax.servlet.error.request_uri");

        if (requstUrl != null && requstUrl.endsWith(".json")){
            return true;
        } else {
            request.getHeader("Accept").contains("application/json");
            return false;
        }
    }


}
