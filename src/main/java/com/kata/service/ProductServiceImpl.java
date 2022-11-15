package com.kata.service;

import com.kata.model.Product;
import com.kata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;

    @Override
    public Product getProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new NotFoundException(id.toString());
        }
        return productRepository.getReferenceById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        if (!productRepository.existsById(product.getId())) {
            throw new NotFoundException(product.getId().toString());
        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void deleteByIdProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new NotFoundException(id.toString());
        }
        productRepository.deleteById(id);
    }
}
