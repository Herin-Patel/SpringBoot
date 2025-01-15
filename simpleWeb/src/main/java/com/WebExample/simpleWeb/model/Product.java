package com.WebExample.simpleWeb.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Product {

    @Id
    private int productId;
    private String productName;
    private int price;

    public Product() {

    }

    public Product(int productId, String productName, int price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId = " + productId +
                ", productName = " + productName +
                ", price = " + price + "}";
    }
}
