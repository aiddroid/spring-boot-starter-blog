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
