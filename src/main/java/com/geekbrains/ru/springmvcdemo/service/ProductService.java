package com.geekbrains.ru.springmvcdemo.service;

import com.geekbrains.ru.springmvcdemo.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    void addProduct(Product product);

}
