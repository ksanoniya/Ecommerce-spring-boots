package com.kalash.Ecommerce.service;

import com.kalash.Ecommerce.model.Product;
import com.kalash.Ecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
@Autowired
private ProductRepo productRepo;
    public List<Product> getducAllProducts() {

        return productRepo.findAll();
    }

    public Product getProductById(int id){
        return productRepo.findById(id).orElse(new Product());
    }
}
