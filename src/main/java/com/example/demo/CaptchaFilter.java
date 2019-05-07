/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 验证码过滤器(拦截器)
 * @author allen
 */
@Component
public class CaptchaFilter extends OncePerRequestFilter implements Filter {
    
    @Autowired
    private CaptchaAuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        
        //必须是登录的post请求才能进行验证，其他的直接放行
        boolean isNeedCheck = "/site/login".equals(request.getRequestURI()) && request.getMethod().equals("POST");
        if(isNeedCheck) {
            try {
                //进行验证码的校验
                validate(new ServletWebRequest(request));
            } catch (AuthenticationException e) {
                //捕获校验出现的异常，交给失败处理类进行进行处理
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        
        // 3. 校验通过，就放行
        filterChain.doFilter(request, response);
    }

    /**
     * 验证码验证
     * @param request
     * @throws InvalidCaptchaException 
     */
    private void validate(ServletWebRequest request) throws InvalidCaptchaException {
        String inputCaptcha = request.getParameter("captcha");
        if (inputCaptcha == null || inputCaptcha.length() == 0) {
            throw new InvalidCaptchaException("验证码不能为空");
        }
        
        //从session获取验证码
        //TODO key应该从kaptcha配置文件动态获取
        String captcha = (String)request.getRequest().getSession().getAttribute("captcha");
        
        System.out.println("input :" + inputCaptcha + ", real " + captcha);
        //比较用户输入的验证码与session中的是否一致
        if (!captcha.equalsIgnoreCase(inputCaptcha)) {
            throw new InvalidCaptchaException("验证码不正确" );
        }
        
        //清除session中的captcha
        request.getRequest().getSession().setAttribute("captcha", "");
    }
 
}
