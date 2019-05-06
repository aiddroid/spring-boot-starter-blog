/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * User 实体
 * @author allen
 */
@Entity
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //id, 自动生成的值
    @Id
    @GeneratedValue
    private Long id;
    
    //用户名,非空唯一
    @Column(nullable = false, unique = true)
    private String username;
    
    //密码,非空
    @Column(nullable = false)
    private String password;
    
    //邮箱,非空唯一
    @Column(nullable = false, unique = true)
    private String email;
    
    //昵称,非空
    @Column(nullable = true, unique = false)
    private String nickname;
    
    //创建时间,非空
    @Column(nullable = false)
    private String createdAt;
    
    public User() {
        super();
    }
    
    /**
     * 构造函数
     * @param username 用户名
     * @param password 密码
     * @param nickname 昵称
     * @param email 邮箱
     * @param createdAt 创建时间 
     */
    public User(String username, String password, String nickname,String email, String createdAt) {
        super();
        
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passWord) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
