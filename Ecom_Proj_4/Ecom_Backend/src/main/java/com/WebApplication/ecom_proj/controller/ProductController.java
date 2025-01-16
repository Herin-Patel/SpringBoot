package com.WebApplication.ecom_proj.controller;

import com.WebApplication.ecom_proj.model.Product;
import com.WebApplication.ecom_proj.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String greet() {
        return "Hello World";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {

        Product productobj = service.getProductById(id);

        if (productobj != null)
            return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(
            @RequestPart Product product,
            @RequestPart MultipartFile imageFile) {
        try {
            System.out.println(product);
            Product savedProduct = service.addProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (Exception expobj) {
            return new ResponseEntity<>(expobj.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId) {
        Product currentProd = service.getProductById(productId);

        byte[] imageFile = currentProd.getImageData();

        return ResponseEntity.ok().
                contentType(MediaType.valueOf(currentProd.getImageType()))
                .body(imageFile);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,
                                                @RequestPart Product product,
                                                @RequestPart MultipartFile imageFile) {
        Product updatedProduct = null;
        try {
            updatedProduct = service.updateProduct(id, product, imageFile);
        } catch (IOException expobj) {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }

        if (updatedProduct != null)
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product deleteProduct = service.getProductById(id);

        if(deleteProduct != null){
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
}
