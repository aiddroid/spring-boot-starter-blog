/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 本测试类由目标类-右键-工具-生成测试 功能生成(netbeans)
 * @author allen
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    
    @Autowired
    private UserRepository userRepository;
    
    public UserRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByUsername method, of class UserRepository.
     */
    @Test
    public void testFindByUsername() {
        System.out.println("findByUsername");
        String username = "admin";
        String expResult = "admin";
        User result = userRepository.findByUsername(username);
        assertEquals(expResult, result.getUsername());
    }

    /**
     * Test of findByUsernameOrEmail method, of class UserRepository.
     */
    @Test
    public void testFindByUsernameOrEmail() {
        System.out.println("findByUsernameOrEmail");
        String username = "admin";
        String email = "allen@gmail.com";
        String usernameResult = "admin";
        String emailResult = "allen@gmail.com";
        User result = userRepository.findByUsernameOrEmail(username, email);
        assertEquals(usernameResult, result.getUsername());
        
        result = userRepository.findByUsernameOrEmail(username, "");
        assertEquals(usernameResult, result.getUsername());
        
        result = userRepository.findByUsernameOrEmail("", email);
        assertEquals(usernameResult, result.getUsername());
    }
    
}
