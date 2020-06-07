package com.mengxuegu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.mengxuegu.springcloud.mapper")
//扫描所有Mapper接口
@SpringBootApplication
@EnableEurekaClient
public class MicroserviceProductProvider_8002 {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProductProvider_8002.class, args); }
}
