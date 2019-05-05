/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 本测试类由目标类-右键-工具-生成测试 功能生成
 * @author allen
 */
public class HomeControllerTest {
    
    public HomeControllerTest() {
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
     * Test of index method, of class HomeController.
     */
    @Test
    public void testIndex() {
        System.out.println("index");
        HomeController instance = new HomeController();
        String expResult = "Hello,world!";
        String result = instance.index();
        assertEquals(expResult, result);
    }
    
}
