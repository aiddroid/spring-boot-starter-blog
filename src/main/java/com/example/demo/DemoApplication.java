package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

/**
 * App类
 * @author allen
 */
@SpringBootApplication
@ImportResource(locations={"classpath:kaptcha.xml"})
public class DemoApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        //指定启动的App
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        //指定资源
        return application.sources(DemoApplication.class);
    }
}
