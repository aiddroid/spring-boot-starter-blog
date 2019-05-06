/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 错误控制器
 * @author allen
 */
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController{
    
    @RequestMapping("/error")
    public String error(ModelMap mm, HttpServletRequest request, HttpServletResponse response) {
        mm.addAttribute("uri", request.getRequestURI());
        mm.addAttribute("code", response.getStatus());
        
        return getErrorPath();
    }

    @Override
    public String getErrorPath() {
        return "/error/error";
    }
}
