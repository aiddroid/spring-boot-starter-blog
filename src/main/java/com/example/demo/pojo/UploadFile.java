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
package com.example.demo.pojo;

/**
 * 上传文件类
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
