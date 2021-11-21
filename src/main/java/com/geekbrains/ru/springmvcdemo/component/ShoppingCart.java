package com.geekbrains.ru.springmvcdemo.component;

import com.geekbrains.ru.springmvcdemo.domain.Product;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
public class ShoppingCart {

    // !!!
    private final Map<Product, Integer> productsWithCount = new HashMap<>();

    public void addProduct(Product product) {
        productsWithCount.merge(product, 1, (prev, cur) -> prev + 1);
    }

    public void removeProduct(Product product) {
        if (productsWithCount.containsKey(product)) {
            Integer count = productsWithCount.get(product);

            removeProduct(product, count);

            return;
        }

        throw new IllegalArgumentException("Product not found in cart");
    }

    private void removeProduct(Product product, Integer count) {
        if (count > 1) {
            productsWithCount.put(product, count - 1);
        } else {
            productsWithCount.remove(product);
        }
    }

    // !!!
    public Map<Product, Integer> getProductsWithCount() {
        return new HashMap<>(productsWithCount);
    }

    public int getCount() {
        return productsWithCount.values().stream()
                .reduce(0, Integer::sum);
    }

}
