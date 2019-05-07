/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.pojo.Article;
import com.example.demo.pojo.UploadFile;
import com.example.demo.service.ArticleService;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 管理员控制器
 * @author allen
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    /**
     * 自动接入
     */
    @Autowired
    private ArticleService articleService;
    
    /**
     * 认证信息
     * @return 
     */
    @RequestMapping("index")
    @ResponseBody
    public Authentication index(Authentication authentication) {
        return authentication;
    }
    
    /**
     * 编写博文表单界面
     * @return 
     */
    @GetMapping
    @RequestMapping("new-article")
    public String newArticle() {
        return "/admin/new-article";
    }
    
    /**
     * 创建博文接口
     * @param request
     * @param title 标题
     * @param slug slug
     * @param content 正文
     * @return 
     */
    @RequestMapping(value = "create-article", method = RequestMethod.POST)
    public ModelAndView createArticle(
            HttpServletRequest request,
            @RequestParam(value = "title", required = false, defaultValue = "") String title,
            @RequestParam(value = "slug", required = false, defaultValue = "") String slug,
            @RequestParam(value = "content", required = false, defaultValue = "") String content
            ) {
        
        Date createdAt = new Date();
        int result = articleService.create(title, slug, content, 0, createdAt, createdAt);
        
        return new ModelAndView("redirect:/");
    }
    
    /**
     * 更新博文界面,GET请求
     * @param mm
     * @param id
     * @return 
     */
    @GetMapping("update-article")
    public String updateArticle(ModelMap mm, @RequestParam(value = "id") Long id) {
        Article article = articleService.find(id);
        mm.addAttribute("article", article);
        return "/admin/update-article";
    }
    
    /**
     * 更新博文接口,POST请求
     * @param mm
     * @param id 博文id
     * @param title 标题
     * @param slug slug
     * @param content 正文
     * @param request
     * @return 
     */
    @PostMapping("update-article")
    public String updateArticle(ModelMap mm, @RequestParam(value = "id") Long id, 
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "slug", required = false) String slug, 
            @RequestParam(value = "content", required = false) String content, 
            HttpServletRequest request) {
        
        Article article = articleService.find(id);
        //更新博文
        articleService.modify(article.getId(), title, slug, content);   
        return "redirect:/article/view/" + article.getId();
    }
    
    /**
     * 删除博文接口
     * @param id 博文id
     * @param redirAttrs
     * @return 
     */
    @RequestMapping("delete-article")
    public String deleteArticle(@RequestParam(value = "id") Long id, 
            RedirectAttributes redirAttrs) {
        
        //删除成功后，添加flash消息
        int result = articleService.delete(id);
        String alert = result > 0 ? "Article deleted!" : "Error occured, try agian later!";
        redirAttrs.addFlashAttribute("alert", alert);
        return "redirect:/";
    }
    
    /**
     * 博文详情页面
     * @param mm
     * @param id 博文id
     * @return 
     */
    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String view(ModelMap mm, @PathVariable Long id) {
        Article article = articleService.find(id);
        mm.addAttribute("article", article);
        mm.addAttribute("message", "what's up!");
        
        return "/article/view";
    }
    
    //参见application.properties设置
    //上传文件访问url path
    @Value("${file.uploadAccessPath}")
    private String uploadAccessPath;
    //上传目录
    @Value("${file.uploadFolder}")
    private String uploadFolder;
    
    /**
     * 文件上传接口
     * @param mfile
     * @return 
     */
    @RequestMapping("upload")
    @ResponseBody
    public HashMap upload(@RequestParam("uploadfile[]") MultipartFile mfile) {
        HashMap uploadedMap = new HashMap();
        
        //判断上传文件是否为空
        if (mfile.isEmpty()) {
            return uploadedMap;
        }
        
        try {
            //为上传文件生成新的文件名
            String uuid = UUID.randomUUID().toString();
            String newName = uuid + ".jpg";
            File destFile = new File(uploadFolder + newName);
            
            //移动上传的临时文件到上传目录
            mfile.transferTo(destFile);
            
            //返回上传结果，json格式
            UploadFile uploadFile = new UploadFile(mfile.getOriginalFilename(), 
                    uploadAccessPath.replace("*", "") + newName);
            uploadedMap.put(uuid, uploadFile);
            
            return uploadedMap;
        } catch (IOException e) {
            System.err.println(e);
        }
        
        return uploadedMap;
    }
}
