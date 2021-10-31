package com.geekbrains.ru.springmvcdemo.service;

import com.geekbrains.ru.springmvcdemo.domain.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getProducts();

    void addProduct(Product product);

    void saveProductWithImage(Product product, MultipartFile image);

    Product getProduct(Long id);

    void del(Long productId);

    List<Product> minSort();

    List<Product> GreaterThan(int min);

    List<Product> LessThan(int max);

    List<Product> Between(int min, int max);
}
