/*
 * Copyright 2019 allen.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
