package com.WebExample.simpleWeb.repository;

import com.WebExample.simpleWeb.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
