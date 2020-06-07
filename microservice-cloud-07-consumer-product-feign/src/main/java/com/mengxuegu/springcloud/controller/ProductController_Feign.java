package com.mengxuegu.springcloud.controller;

import com.mengxuegu.springcloud.entities.Product;
import com.mengxuegu.springcloud.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController_Feign {

    @Qualifier("productClientServiceFallBack")
    @Autowired
    private ProductClientService service;
//
//    //修改为Eureka注册中心的地址
//    private static final String REST_URL_PREFIX = "http://MICROSERVICE-PRODUCT";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/product/add")
    public boolean add(Product product) {
        return service.add(product);
    }

    @RequestMapping(value = "/consumer/product/get/{id}")
    public Product get(@PathVariable("id") Long id)
    { return service.get(id);
    }

    @RequestMapping(value = "/consumer/product/list")
    public List<Product> list() {
        return service.list();
    }
}
