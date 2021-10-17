package com.geekbrains.ru.springmvcdemo.controller;

import com.geekbrains.ru.springmvcdemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    //http://localhost:8080/product?page_num=1&size=20
    //http://localhost:8080/product?size=20
    public ModelAndView getProducts(@RequestParam(required = false, value = "page_num") int pageNum,
                                    @RequestParam int size) {

        ModelAndView modelAndView = new ModelAndView("product/productList");
        modelAndView.addObject("products", productService.getProducts());

        return modelAndView;
    }

//    @GetMapping("/{productId}")
//    //http://localhost:8080/product/1
//    //http://localhost:8080/product/2
//    public ModelAndView getProduct(@PathVariable Long productId) {
//        ModelAndView modelAndView = new ModelAndView("product/product");
//        modelAndView.addObject("product", productService.getProduct(productId));
//
//        return modelAndView;
//    }

//    @GetMapping
//    public String getProducts(Model model) {
//        model.addAttribute("products", productService.getProducts());
//
//        return "product/productList";

//    }


}
