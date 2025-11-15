package com.kalash.Ecommerce.controller;

import com.kalash.Ecommerce.model.Product;
import com.kalash.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class productController {
    @RequestMapping("/")
    public String greeting(){
        return "Hello World!";
    }

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts(){

        return service.getducAllProducts();
    }


    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){
    return service.getProductById(id);
    }
}
