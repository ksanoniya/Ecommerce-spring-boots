package com.kalash.Ecommerce.controller;

import com.kalash.Ecommerce.model.Product;
import com.kalash.Ecommerce.service.ProductService;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.http.HttpResponse;
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

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestPart Product product,
                                              @RequestPart MultipartFile imagefile){
        try {
            Product product1 = service.addproduct(product, imagefile);
             return new ResponseEntity(product, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/product/{productId}/images")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
        Product product = service.getProductById(productId);
        byte[] imageFile = product.getImageDate();
        return ResponseEntity.ok().contentType(MediaType.valueOf((product.getImageType())))
                .body(imageFile);
    }
}
