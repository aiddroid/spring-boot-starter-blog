/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.pojo.Article;
import com.example.demo.service.ArticleService;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author allen
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    
    @Autowired
    private ArticleService articleService;
    
    @RequestMapping("index")
    public Article index() {
        return articleService.find(1L);
    }
    
    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public Article view(@PathVariable Long id) {
        return articleService.find(id);
    }
}
