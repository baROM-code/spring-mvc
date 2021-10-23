package com.geekbrains.ru.springmvcdemo.controller;

import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    //http://localhost:8080/product?page_num=1&size=20
    //http://localhost:8080/product?size=20
    public ModelAndView getProducts() {
        ModelAndView modelAndView = new ModelAndView("product/productList");
        modelAndView.addObject("products", productService.getProducts());
        return modelAndView;
    }

    @PostMapping
    public RedirectView saveProduct(@ModelAttribute Product product,
                                    @RequestParam(required = false) MultipartFile image) {
        productService.saveProductWithImage(product, image);
        return new RedirectView("/product");
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/productAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String Submit(@ModelAttribute Product product,
                         @RequestParam(required = false) MultipartFile image,
                         Model model) {
        model.addAttribute("product", product);
        //productService.addProduct(product);
        productService.saveProductWithImage(product, image);
        return "product/info1";
    }


//    @GetMapping("/{productId}")
//    //http://localhost:8080/product/1
//    //http://localhost:8080/product/2
//    public ModelAndView getProduct(@PathVariable Long productId) {
//        ModelAndView modelAndView = new ModelAndView("product/product");
//        modelAndView.addObject("product", productService.getProduct(productId));
//        return modelAndView;
//    }

//    @GetMapping
//    public String getProducts(Model model) {
//        model.addAttribute("products", productService.getProducts());
//
//        return "product/productList";

//    }


}
