/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 站点控制器
 * @author allen
 */
@Controller
public class SiteController implements ErrorController{
    
    /**
     * 登录界面
     * @param mm
     * @param request
     * @return 
     */
    @RequestMapping(value = "/site/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(ModelMap mm, HttpServletRequest request) {
        String message = "hello, world!";
        mm.addAttribute("message", message);
         
        return "/site/login";
    }
    
    /**
     * 错误页面
     * @param mm
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping("/error")
    public String error(ModelMap mm, HttpServletRequest request, HttpServletResponse response) {
        mm.addAttribute("uri", request.getRequestURI());
        mm.addAttribute("code", response.getStatus());
        
        return getErrorPath();
    }

    @Override
    public String getErrorPath() {
        return "/site/error";
    }
}
