package com.kata.controller;

import com.kata.config.ProductMapperConfig;
import com.kata.dto.ProductDto;
import com.kata.model.Product;
import com.kata.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
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

@Tag(name = "REST контроллер для работы с товарами")
@RestController
@RequestMapping("products/api")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @Operation(summary = "Получение списка всех товаров")
    @GetMapping()
    public List<ProductDto> showAllProducts() {
        List<Product> products = productService.getAllProduct();
        return ProductMapperConfig.convertList(products, this::convertToProductDto);
    }

    @Operation(summary = "Получение информации о товаре по его id")
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable("id") @Parameter(description = "id товара") Long id) {
        return convertToProductDto(productService.getProduct(id));
    }

    @Operation(summary = "Добавление нового товара")
    @PostMapping()
    public ResponseEntity<ProductDto> addNewProduct(@RequestBody ProductDto productDto) {
        ProductDto newProduct = convertToProductDto(productService.saveProduct(convertToProduct(productDto)));
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление информации о товаре")
    @PutMapping()
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        ProductDto updatedProduct = convertToProductDto(productService.updateProduct(convertToProduct(productDto)));
        return new ResponseEntity<>(updatedProduct, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Удаление товара по его id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable @Parameter(description = "id товара") Long id) {
        productService.deleteByIdProduct(id);
    }

    private ProductDto convertToProductDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    private Product convertToProduct(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }

}
