/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Web安全配置
 * @author allen
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
    
    //自动接入
    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private CaptchaFilter captchaFilter;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
//        http.csrf().disable();
        
        http
            .addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class)//在登录的账号密码验证行为前增加captcha验证
            .authorizeRequests()
            .antMatchers("/", "/static/**", "/about/**", "/article/**", "/site/login", "/site/captcha", "/uploadfile/**") // 不需要登录就可以访问
            .permitAll()
            //.antMatchers("/admin/**").hasAnyRole("ADMIN") // 需要具有ROLE_ADMIN角色才能访问
            .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/site/login") // 设置登录页面路径(只是显示前端页面,具体的登录认证逻辑由spring实现)
//                    .loginProcessingUrl("/site/form")
                .defaultSuccessUrl("/") // 设置默认登录成功后跳转的页面
                .permitAll()
            .and()
                .logout()
                .logoutUrl("/site/logout")
                .permitAll()
            ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //spring实现的用户认证, 用户名密码存储于内存中
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("123456").roles("ADMIN")
//                .and()
//                .passwordEncoder(new PlainPasswordEncoder());

        //使用数据库记录进行用户认证
        auth.userDetailsService(myUserDetailService).passwordEncoder(new PlainPasswordEncoder());
    }
    
}

/**
 * 密码编码器(明文验证,实际应用中建议采用SHA1等进行编码)
 * @author allen
 */
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
