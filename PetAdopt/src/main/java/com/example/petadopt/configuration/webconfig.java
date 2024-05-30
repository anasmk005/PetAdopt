package com.example.petadopt.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class webconfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/");

        registry.addResourceHandler("/static/css/**","/js/**", "/static/img/**")
                .addResourceLocations("classpath:/static/css/","classpath:/static/js/","classpath:/static/img/");
    }
}
