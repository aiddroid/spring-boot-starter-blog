/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dao;

import com.example.demo.pojo.Article;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * 博文DAO
 * @author allen
 */
@Mapper
public interface ArticleDao {
    
    /**
     * 新增博文
     * @param map 博文数据
     * @return 
     */
    int add(HashMap<String, String> map);
    
    /**
     * 更新博文
     * @param map 博文数据
     * @return 
     */
    int update(HashMap<String, String> map);
    
    /**
     * 删除博文
     * @param id 博文id
     * @return 
     */
    int delete(Long id);
    
    /**
     * 根据id获取博文
     * @param id 博文id
     * @return 
     */
    Article getById(Long id);
    
    /**
     * 按照分页获取博文
     * @param map 分页数据
     * @return 
     */
    List<Article> getList(HashMap<String, String> map);
    
    /**
     * 获取全部博文
     * @return 
     */
    List<Article> getAll();
    
    /**
     * 获取博文数量
     * @return 
     */
    int getTotalCount();
}
