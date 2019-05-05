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
                .antMatchers("/", "/static/**","/site/login") // 不需要登录就可以访问
                .permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN") // 需要具有ROLE_ADMIN角色才能访问
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/site/login") // 设置登录页面
//                    .loginProcessingUrl("/site/form")
                    .defaultSuccessUrl("/") // 设置默认登录成功后跳转的页面
                ;
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
