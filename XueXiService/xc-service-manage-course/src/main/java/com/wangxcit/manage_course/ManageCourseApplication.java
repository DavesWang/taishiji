package com.wangxcit.manage_course;

import com.wangxcit.framework.interceptor.FeignClientInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@EnableFeignClients  //配置Feign 完成远程调用
@EnableDiscoveryClient //Eureka的客户端注册到服务端
@SpringBootApplication
@EntityScan("com.wangxcit.framework.domain.course")//扫描实体类
@ComponentScan(basePackages={"com.wangxcit.api"})//扫描接口
@ComponentScan(basePackages={"com.wangxcit.manage_course"})
@ComponentScan(basePackages={"com.wangxcit.framework"})//扫描common下的所有类
public class ManageCourseApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ManageCourseApplication.class, args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
    // common工程下定义了一个Feign拦截器
    @Bean
    public FeignClientInterceptor getFeignClientInterceptor(){
        return new FeignClientInterceptor();
    }
}
