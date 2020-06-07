package com.mengxuegu.springcloud.service;

import com.mengxuegu.springcloud.entities.Product;
import com.mengxuegu.springcloud.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

@Autowired(required = false)
private ProductMapper productMapper;
@Override
public boolean add(Product product) {
    return productMapper.addProduct(product);
}
@Override
public Product get(Long id) {
    return productMapper.findById(id);
}
@Override
public List<Product> list() {
    return productMapper.findAll();
}}


