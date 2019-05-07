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

/**
 * 首页控制器
 * @author allen
 */
@Controller
public class HomeController {
    
    /**
     * 自动接入
     */
    @Autowired
    private ArticleService articleService;
    
    /**
     * 网站首页
     * @param mm
     * @param page 页数
     * @param count 每页博文数量
     * @param request
     * @param authentication
     * @return 
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap mm, 
            @RequestParam(value = "page", required = false, defaultValue = "1") int page, 
            @RequestParam(value = "count", required = false, defaultValue = "10") int count, 
            HttpServletRequest request, 
            Authentication authentication) {
        
        //获取对应分页的博文列表
        List<Article> articles = articleService.get(page, count);
        mm.addAttribute("articles", articles);
        
        //计算页数
        int totalCount = articleService.getTotalCount();
        int maxPage = (int)Math.ceil((double)totalCount / count);
        mm.addAttribute("page", page);
        mm.addAttribute("maxPage", maxPage);
        
        //判断是否登录
        if (authentication != null && authentication.isAuthenticated()) {
            request.getSession().setAttribute("username", "admin");
            System.out.println(request.getSession().getAttribute("username"));
        }
        return "/home";
    } 
}
