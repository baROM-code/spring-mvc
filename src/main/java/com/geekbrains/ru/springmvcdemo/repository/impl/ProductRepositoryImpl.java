package com.geekbrains.ru.springmvcdemo.repository.impl;

import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products;

    @Override
    public Product get(Long id) {
        return Product.builder()
                .id(id)
                .title("title")
                .price(100)
                .build();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void add(Product product) {
        System.out.println(product);

        // Выдает ошибку в этом месте !!!
        products.add(product);
        System.out.println(products);
    }

}
