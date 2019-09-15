package com.wangxcit.manage_cms_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.wangxcit.framework.domain.cms")//扫描实体类
@ComponentScan(basePackages={"com.wangxcit.framework"})//扫描common下的所有类
@ComponentScan(basePackages={"com.wangxcit.manage_cms_client"})
public class ManageCmsClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageCmsClientApplication.class, args);
    }
}