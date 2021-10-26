package com.learnjava.frenemy.config;

import com.learnjava.frenemy.fornatter.PhoneNumberFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.learnjava.frenemy")
@PropertySources({@PropertySource("classpath:validation-messages.properties"),
        @PropertySource("classpath:email.properties")})
public class FrenemyAppConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;

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

    // CONFIGURING JAVA MAIL SENDER
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        System.out.println(env.getProperty("mail.host"));
        System.out.println(env.getProperty("mail.username"));
        System.out.println(env.getProperty("mail.password"));
        System.out.println(env.getProperty("mail.port"));
        System.out.println(env.getProperty("mail.smtp.starttls.enable"));
        System.out.println(env.getProperty("mail.smtp.ssl.trust"));

        javaMailSender.setHost(env.getProperty("mail.host"));

        // TODO : Enter valid email address below
        javaMailSender.setUsername(env.getProperty("mail.username"));

        // TODO : Enter password below
        javaMailSender.setPassword(env.getProperty("mail.password"));

        javaMailSender.setPort(Integer.parseInt(env.getProperty("mail.port")));

        Properties mailProperties = new Properties();
        mailProperties.put(env.getProperty("mail.smtp.starttls.enable"), true);
        mailProperties.put(env.getProperty("mail.smtp.ssl.trust"), env.getProperty("mail.host"));

        javaMailSender.setJavaMailProperties(mailProperties);

        return javaMailSender;
        //TODO : TURN ON GMAIL LESS SECURE APP IN THE GOOGLE ACCOUNT
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("test123");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5433/studentdb?useSSL=false");
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        return driverManagerDataSource;
    }
}
