package com.kata.service;

import com.kata.model.Product;
import java.util.List;

public interface ProductService {
    Product getProduct(Long id);

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    List<Product> getAllProduct();

    void deleteByIdProduct(Long id);

}
