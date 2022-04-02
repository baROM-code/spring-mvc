package com.geekbrains.ru.springmvcdemo;

import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringMvcDemo2Application {



    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringMvcDemo2Application.class, args);

        /*
        ProductService productService = context.getBean(ProductService.class);
        Product product = Product.builder()
                .description("Test Build")
                .price(567)
                .title("Product created with Builder")
                .build();
        product.setId(77L);
        productService.addProduct(product);

         */
    }

}
