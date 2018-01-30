package com.yhshao.springboot.config;

import com.yhshao.springboot.properties.BeetlProperties;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shaoqi on 18/1/25.
 */
@Configuration
public class BeetlConf {




    @Autowired
    BeetlProperties beetlProperties;

    @Bean(name = "beetlConfig")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        //获取Spring Boot 的ClassLoader
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if(loader==null){
            loader = BeetlConf.class.getClassLoader();
        }
        beetlGroupUtilConfiguration.setConfigProperties(beetlProperties.getProperties());//额外的配置，可以覆盖默认配置，一般不需要
        beetlGroupUtilConfiguration.setResourceLoader(new ClasspathResourceLoader(loader, beetlProperties.getPrefix()));
        beetlGroupUtilConfiguration.init();
        //如果使用了优化编译器，涉及到字节码操作，需要添加ClassLoader
        beetlGroupUtilConfiguration.getGroupTemplate().setClassLoader(loader);
        return beetlGroupUtilConfiguration;

    }

    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        return beetlSpringViewResolver;
    }



}
