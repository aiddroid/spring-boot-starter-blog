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
package com.example.demo.service;

import com.example.demo.dao.ArticleDao;
import com.example.demo.pojo.Article;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 博文服务
 * @author allen
 */
@Service
public class ArticleService {
    
    /**
     * 自动接入
     */
    @Autowired
    private ArticleDao articleDao;
    
    /**
     * 根据id查找博文
     * @param id
     * @return 
     */
    public Article find(Long id) {
        return articleDao.getById(id);
    }
    
    /**
     * 创建博文
     * @param title 标题
     * @param slug slug
     * @param content 正文
     * @param uid 作者id
     * @param createdAt 创建时间
     * @param updatedAt 更新时间
     * @return 
     */
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
    
    /**
     * 修改博文
     * @param id 博文id
     * @param title 标题
     * @param slug slug
     * @param content 正文
     * @return 
     */
    public int modify(Long id, String title, String slug, String content) {
        HashMap map = new HashMap();
        map.put("id", id);
        map.put("title", title);
        map.put("slug", slug);
        map.put("content", content);
        map.put("updatedAt", new Date());
        
        return articleDao.update(map);
    }
    
    /**
     * 删除博文
     * @param id
     * @return 
     */
    public int delete(Long id) {
        return articleDao.delete(id);
    }
    
    /**
     * 获取分页博文
     * @param page 页数
     * @param count 每页数量
     * @return 
     */
    public List<Article> get(int page, int count) {
        HashMap map = new HashMap();
        map.put("offset", (page - 1) * count);
        map.put("count", count);
        return articleDao.getList(map);
    }
    
    /**
     * 获取全部博文
     * @return 
     */
    public List<Article> all() {
        return articleDao.getAll();
    }
    
    /**
     * 获取博文数量
     * @return 
     */
    public int getTotalCount() {
        return articleDao.getTotalCount();
    }
}
