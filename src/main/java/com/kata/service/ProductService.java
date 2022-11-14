package com.kata.service;

import com.kata.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getProduct(Long id);

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    List<Product> getAllProduct();

    void deleteByIdProduct(Long id);

    boolean deleteAllProducts();
}
