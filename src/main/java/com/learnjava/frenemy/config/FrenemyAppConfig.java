package com.learnjava.frenemy.config;

import com.learnjava.frenemy.fornatter.PhoneNumberFormatter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.learnjava.frenemy.controller")
@PropertySource("classpath:ValidationMessages.properties")
public class FrenemyAppConfig implements WebMvcConfigurer {

    @Bean
    InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    // LOADING MESSAGE PROPERTIES FILE WITHOUT @PropertySource ANNOTATION
//    @Bean
//    MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("ValidationMessages");
//        return messageSource;
//
//    }

    // REGISTERING CUSTOM FORMATTER FOR SPRING TO PICK UP
    @Override
    public void addFormatters(FormatterRegistry registry) {
        System.out.println("***** REGISTERING CUSTOM PHONE FORMATTER FOR SPRING TO PICK UP *****");
        registry.addFormatter(new PhoneNumberFormatter());
    }
}
