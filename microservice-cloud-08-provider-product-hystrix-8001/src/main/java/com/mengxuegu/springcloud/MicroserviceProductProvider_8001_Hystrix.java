package com.mengxuegu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@MapperScan("com.mengxuegu.springcloud.mapper")
//扫描所有Mapper接口
@EnableHystrix //开启 Hystrix 熔断机制的支持
@SpringBootApplication
@EnableEurekaClient
public class MicroserviceProductProvider_8001_Hystrix {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProductProvider_8001_Hystrix.class, args); }
}
