/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author allen
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
        
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping("admin")
    public User info() {
        User user = new User("admin", "123456", "allen", "allen@gmail.com", "2019-03-03 12:00:00");
        
        //因为UserController标识了@RestController，所以返回的User对象会被转换为json字符串输出
        return user;
    }
    
    @RequestMapping("get")
    public User get() {
        User user = userRepository.findByUsername("admin");
        
        return user;
    }
    
    @RequestMapping("save")
    public Long save() {
        User user = new User("admin", "123456", "allen", "allen@gmail.com", "2019-03-03 12:00:00");
        userRepository.save(user);
        
        return user.getId();
    }
}
