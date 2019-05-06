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
    
    //上传文件id,即标识符
    private String id;
    
    //上传文件url,相对路径
    private String url;

    /**
     * 构造函数
     * @param id 上传文件id
     * @param path 上传文件路径
     */
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
