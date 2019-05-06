/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.dao.ArticleDao;
import com.example.demo.pojo.Article;
import java.util.Date;
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
    
    public int create(String title, String slug, String content, int uid, Date createdAt, Date updatedAt) {        
        HashMap map = new HashMap();
        map.put("title", title);
        map.put("slug", slug);
        map.put("content", content);
        map.put("uid", uid);
        map.put("createdAt", createdAt);
        map.put("updatedAt", updatedAt);
        return articleDao.add(map);
    }
    
    public int modify(Long id, String title, String slug, String content) {
        HashMap map = new HashMap();
        map.put("id", id);
        map.put("title", title);
        map.put("slug", slug);
        map.put("content", content);
        map.put("updatedAt", new Date());
        
        return articleDao.update(map);
    }
    
    public int delete(Long id) {
        return articleDao.delete(id);
    }
    
    public List<Article> get(int page, int count) {
        HashMap map = new HashMap();
        map.put("offset", (page - 1) * count);
        map.put("count", count);
        return articleDao.getList(map);
    }
    
    public List<Article> all() {
        return articleDao.getAll();
    }
    
    public int totalCount() {
        return articleDao.totalCount();
    }
}
