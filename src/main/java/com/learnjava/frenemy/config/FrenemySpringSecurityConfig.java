package com.learnjava.frenemy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// This class along with the @EnableWebSecurity helps us to create spring security filter chain

@Configuration
@EnableWebSecurity(debug = true)
public class FrenemySpringSecurityConfig extends WebSecurityConfigurerAdapter {
}
