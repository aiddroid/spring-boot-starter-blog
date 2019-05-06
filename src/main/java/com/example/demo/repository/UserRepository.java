/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User Repository
 * @author allen
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
    /**
     * 根据用户名查询用户
     *    jpa会根据函数名规则,自动实现具体SQL查询功能
     * @param username 用户名
     * @return 
     */
    User findByUsername(String username);
    
    /**
     * 更加用户名或邮箱查询用户
     *    jpa会根据函数名规则,自动实现具体SQL查询功能
     * @param username 用户名
     * @param email 邮箱
     * @return 
     */
    User findByUsernameOrEmail(String username, String email);
}
