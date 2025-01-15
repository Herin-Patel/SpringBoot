package com.WebExample.simpleWeb.controller;

import com.WebExample.simpleWeb.model.Product;
import com.WebExample.simpleWeb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable int productId) {
        return service.getProductById(productId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product newProduct) {
        service.addProduct(newProduct);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product modifyProduct) {
        service.updateProduct(modifyProduct);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        service.deleteProduct(productId);
    }
}
