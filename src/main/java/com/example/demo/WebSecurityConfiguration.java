/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author allen
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        
        http.authorizeRequests()
            .antMatchers("/", "/static/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                    .formLogin()
                    .loginPage("/site/login").permitAll()
                    .successForwardUrl("/")
                .and()
                    .logout()
                    .logoutUrl("/site/logout").permitAll()
                .and()
                    .rememberMe()
                    .tokenValiditySeconds(86400 * 30);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("123456").roles("ADMIN")
                .and()
                .passwordEncoder(new PlainPasswordEncoder());
    }
    
}

class PlainPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence cs) {
       return cs.toString();
    }

    @Override
    public boolean matches(CharSequence cs, String s) {
        return s.equals(cs.toString());
    }
    
}
