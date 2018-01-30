//package com.yhshao.springboot.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//
///**
// * Created by shaoqi on 18/1/17.
// */
//@Configuration
//@Aspect
//public class AOPConfig {
//
//
//    @Around("@within(org.springframework.web.bind.annotation.RestController)")
//    public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable {
//
//        try {
//            Object[] args = pjp.getArgs();
//            System.out.println("args:"+ Arrays.asList(args));
//            // 调用方法
//            Object o = pjp.proceed();
//            System.out.println("return:" +o);
//            return o;
//
//        }catch (Throwable e){
//            throw e;
//        }
//
//
//    }
//
//
//
//
//}
