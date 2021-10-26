package com.learnjava.frenemy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

// This class along with the @EnableWebSecurity helps us to create spring security filter chain

@Configuration
@EnableWebSecurity(debug = true)
public class FrenemySpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // IN-MEMORY AUTHENTICATION
//        auth.inMemoryAuthentication()
//                .withUser("user1")
//                .password("$2a$10$EwGcPNYlvUdmgBx4qNjAxOinuU4GVKy3T93549lhZJQ220jbU6qk6")
//                .roles("admin");

        // JDBC AUTHENTICATION
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // DEFAULT
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic()
//        ;

        // CUSTOMIZED
        http.authorizeRequests()
                .antMatchers("/test", "/custom-login", "/process-login").permitAll()
                .antMatchers("/*").authenticated()
                .and()
                .formLogin().loginPage("/custom-login").loginProcessingUrl("/process-login")
                .and()
                .httpBasic()
                .and()
                .logout()
                // when custom-login given then this logout also has to be given.
                ;
        // Spring automatically handles the process-login url data submission, no need to write a controller handler method
        // for /procees-login
    }
}
