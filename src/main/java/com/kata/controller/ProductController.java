package com.kata.controller;

import com.kata.model.Product;
import com.kata.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@Tag(name = "REST контроллер для работы с товарами")
@RestController
@RequestMapping("products/api")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Получение списка всех товаров")
    @GetMapping()
    public List<Product> showAllProducts() {
        return productService.getAllProduct();
    }

    @Operation(summary = "Получение информации о товаре по его id")
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") @Parameter(description = "id товара") Long id) {
        return productService.getProduct(id);
    }

    @Operation(summary = "Добавление нового товара")
    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
        Product newProduct = productService.saveProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление информации о товаре")
    @PutMapping()
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Удаление товара по его id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable @Parameter(description = "id товара") Long id) {
        productService.deleteByIdProduct(id);
    }
}
