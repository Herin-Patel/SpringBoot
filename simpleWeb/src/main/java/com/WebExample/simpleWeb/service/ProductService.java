package com.WebExample.simpleWeb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.springframework.stereotype.Service;
import com.WebExample.simpleWeb.model.Product;
import com.WebExample.simpleWeb.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> products = new ArrayList<>(
//            Arrays.asList(
//                    new Product(101, "Iphone", 50000),
//                    new Product(102, "Canon", 70000),
//                    new Product(103, "Mic", 25000))
//    );

    public List<Product> getProducts() {
//        return products;
        return repo.findAll();
    }

    public Product getProductById(int productId) {
//        return products.stream()
//                .filter(p -> p.getProductId() == productId)
//                .findFirst()
//                .orElse(new Product(100, "No Item Found", 0));
        return repo.findById(productId).orElse(new Product());
    }

    public void addProduct(Product newProduct) {
//        products.add(newProduct);
        repo.save(newProduct);
    }

    public void updateProduct(Product modifyProduct) {
//        int index = 0;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getProductId() == modifyProduct.getProductId()) {
//                index = i;
//            }
//        }
//        products.set(index, modifyProduct);
        repo.save(modifyProduct);
    }

    public void deleteProduct(int productId) {
//        int index = 0;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getProductId() == productId) {
//                index = i;
//            }
//        }
//        products.remove(index);
        repo.deleteById(productId);
    }
}
