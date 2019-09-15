package com.wangxcit.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
@EnableDiscoveryClient  //一个EurekaClient 从EurekaServer发现服务
@SpringBootApplication
@EntityScan("com.wangxcit.framework.domain.cms")//扫描实体类
@ComponentScan(basePackages = {"com.wangxcit.api"})//扫描接口
@ComponentScan(basePackages = {"com.wangxcit.manage_cms"})//扫描本项目下所有类
public class StartClass {
    public static void main(String args[]){
        SpringApplication.run(StartClass.class);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
