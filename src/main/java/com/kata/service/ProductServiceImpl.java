package com.kata.service;

import com.kata.model.Product;
import com.kata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> getProduct(Long id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        if (foundProduct.isEmpty()) {
            throw new NotFoundException(id.toString());
        }
        return foundProduct;
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

    @Override
    public boolean deleteAllProducts() {
        if (productRepository.count() > 0) {
            productRepository.deleteAll();
            return true;
        }
        return false;
    }


}
