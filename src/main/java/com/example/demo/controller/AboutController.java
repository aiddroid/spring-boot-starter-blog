/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 关于控制器
 * @author allen
 */
@Controller
@RequestMapping("/about")
public class AboutController {
    
    /**
     * 关于页面
     * @param mm
     * @return 
     */
    @RequestMapping("index")
    public String index(ModelMap mm) {
        String message = "hello, world!";
        mm.addAttribute("message", message);
        
        return "/about/index";
    }
}
