/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.dao.ArticleDao;
import com.example.demo.pojo.Article;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author allen
 */
@Service
public class ArticleService {
    
    @Autowired
    private ArticleDao articleDao;
    
    public Article find(Long id) {
        return articleDao.getById(id);
    }
    
    public List<Article> get(int offset, int count) {
        HashMap map = new HashMap();
        map.put("offset", offset);
        map.put("count", count);
        return articleDao.getList(map);
    }
    
    public List<Article> all() {
        return articleDao.getAll();
    }
}
