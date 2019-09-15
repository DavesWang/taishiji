package com.wangxcit.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient //允许发现服务，没有加FeignClient 因为本服务不用远程调取其他服务
@SpringBootApplication
@EntityScan("com.wangxcit.framework.domain.search")//扫描实体类
@ComponentScan(basePackages={"com.wangxcit.api"})//扫描接口
@ComponentScan(basePackages={"com.wangxcit.search"})//扫描本项目下的所有类
@ComponentScan(basePackages={"com.wangxcit.framework"})//扫描common下的所有类
public class SearchApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SearchApplication.class, args);
    }

}
