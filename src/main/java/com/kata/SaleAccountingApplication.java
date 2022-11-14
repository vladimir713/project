package com.kata;

import com.kata.model.Product;
import com.kata.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaleAccountingApplication {
    private static ProductService productService;
    @Autowired
    public SaleAccountingApplication(ProductService productService) {
        this.productService = productService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SaleAccountingApplication.class, args);
//        Product p = new Product("eee", "wewe", "scwf", "fwef", 333L, 444L);
//        productService.saveProduct(p);
//        productService.deleteByIdProduct(1L);
//        p = new Product("eee2", "wewe2", "scwf2", "fwef2", 333L, 444L);
//        productService.saveProduct(p);
//        productService.deleteAllProducts();
        productService.saveProduct(new Product("eee233", "wewe233", "scwf233", "fwef233", 3333L, 444L));
        productService.saveProduct(new Product("eee23", "wewe23", "scwf23", "fwef23", 333L, 444L));
    }

}
