/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Web配置
 * @author allen
 */
@Configuration
//启用mvc
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer{
    
    /**
     * 获取视图资源解析器
     * @return 
     */
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        //指定视图资源路径
        resolver.setPrefix("/WEB-INF/view");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        
        return resolver;
    }
    
    //启用默认的Servlet处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    } 
    
    //参见application.properties设置
    //上传文件访问url path
    @Value("${file.uploadAccessPath}")
    private String uploadAccessPath;
    //上传目录
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    //添加上传文件的静态资源解析(java与php不同,无法直接上传到webroot目录下)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(uploadAccessPath).addResourceLocations("file://" + uploadFolder);
    }
    
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }
    
    @Bean
    public FilterRegistrationBean testFilterRegistrationBean() {
        //注册自定义拦截器
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("paramName", "paramValue");
        registrationBean.setName("MyFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }
    
    /**
     * 自定义拦截器
     */
    public class MyFilter implements Filter {

        @Override
        public void init(FilterConfig fc) throws ServletException {
            Filter.super.init(fc); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) sr;
            //具体的拦截操作,这里只是输出当前的url
            System.out.println("this is MyFilter, current URL :" + request.getRequestURI());
            
            fc.doFilter(sr, sr1);
        }

        @Override
        public void destroy() {
            Filter.super.destroy(); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
