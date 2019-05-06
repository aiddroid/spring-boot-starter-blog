/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.pojo;

/**
 *
 * @author allen
 */
public class UploadFile {
    
    private String id;
    private String url;

    public UploadFile(String id, String path) {
        this.id = id;
        this.url = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
