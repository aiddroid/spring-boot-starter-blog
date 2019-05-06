/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.pojo.Article;
import com.example.demo.service.ArticleService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author allen
 */
@Controller
public class HomeController {
    
    @Autowired
    private ArticleService articleService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap mm, 
            @RequestParam(value = "page", required = false, defaultValue = "1") int page, 
            @RequestParam(value = "count", required = false, defaultValue = "10") int count, 
            HttpServletRequest request, 
            Authentication authentication) {
        List<Article> articles = articleService.get(page, count);
        
        mm.addAttribute("articles", articles);
        
        int totalCount = articleService.totalCount();
        int maxPage = (int)Math.ceil((double)totalCount / count);
        mm.addAttribute("page", page);
        mm.addAttribute("maxPage", maxPage);
        
        if (authentication != null && authentication.isAuthenticated()) {
            request.getSession().setAttribute("username", "admin");
            System.out.println(request.getSession().getAttribute("username"));
        }
        return "/home";
    } 
}
