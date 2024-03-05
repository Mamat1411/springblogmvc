package com.springboot.springblogmvc.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/home").setViewName("springsecurities/home");
        registry.addViewController("/").setViewName("springsecurities/home");
        registry.addViewController("/hello").setViewName("springsecurities/hello");
        registry.addViewController("/login").setViewName("springsecurities/login");
    }
}
