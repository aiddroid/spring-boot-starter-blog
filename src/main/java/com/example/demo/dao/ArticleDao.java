/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dao;

import com.example.demo.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author allen
 */
@Mapper
public interface ArticleDao {
    
    Article getById(Long id);
}
