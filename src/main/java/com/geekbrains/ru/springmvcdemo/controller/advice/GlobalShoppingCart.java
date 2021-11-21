package com.geekbrains.ru.springmvcdemo.controller.advice;

import com.geekbrains.ru.springmvcdemo.component.ShoppingCart;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@ControllerAdvice
public class GlobalShoppingCart {

    @ModelAttribute("shoppingCart")
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }

}
