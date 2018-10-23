package com.example.webpractice;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.val;

@Configuration
public class WebApplicationConfigration  implements WebMvcConfigurer{
    @Bean
    FilterRegistrationBean<LoginCheckFilter> myFilterRegistration () {
        val frb = new FilterRegistrationBean<LoginCheckFilter>();
        frb.setFilter(new LoginCheckFilter());
        frb.setUrlPatterns(Arrays.asList("/*"));
        return frb;
    }
}
