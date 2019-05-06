/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.pojo.Article;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章控制器
 * @author allen
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    
    /**
     * 自动接入
     */
    @Autowired
    private ArticleService articleService;
    
    /**
     * 博文详情页面
     * @param mm
     * @param id
     * @return 
     */
    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String view(ModelMap mm, @PathVariable Long id) {
        Article article = articleService.find(id);
        mm.addAttribute("article", article);
        mm.addAttribute("message", "what's up!");
          
        return "/article/view";
    }
}
