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
