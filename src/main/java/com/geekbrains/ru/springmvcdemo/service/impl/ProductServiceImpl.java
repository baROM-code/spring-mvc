package com.geekbrains.ru.springmvcdemo.service.impl;

import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.repository.ProductDao;
import com.geekbrains.ru.springmvcdemo.repository.ProductRepository;
import com.geekbrains.ru.springmvcdemo.service.ProductService;
import com.geekbrains.ru.springmvcdemo.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    // private final ProductRepository productRepository;
    private final ProductDao productDao;

    @Override
    public List<Product> getProducts() {
        return productDao.findAll();
        // return List.of(productDao.findById(1L));
    }

    @Override
    public void addProduct(Product product) {
        productDao.add(product);
    }

    @Override
    public void saveProductWithImage(Product product, MultipartFile image) {
        // product save...
        productDao.add(product);
        if (image != null && !image.isEmpty()) {
            Path pathImage = FileUtils.saveProductImage(image);
            product.setImageLink(pathImage.toString());

            // update
        }

        // return product
    }
}
