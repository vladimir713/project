package com.kata.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "products")
@Entity
@Data
@Schema(description = "Сущность товара")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор (id) товара")
    private Long id;

    @Schema(description = "Наименование товара")
    private String name;

    @Schema(description = "Признак, что это товар")
    private static final boolean ISPRODUCT = true;

    @Schema(description = "Описание товара")
    private String description;

    @Schema(description = "Код производителя товара")
    private String vendorCode;

    @Schema(description = "Внешний код товара")
    private String externalCode;

    @Schema(description = "Вес товара")
    private Long weight;

    @Schema(description = "Объём товара")
    private Long volume;

    @Schema(description = "Закупочная цена")
    private Double purchasePrice;

    @Schema(description = "Цена продажи")
    private Double salePrice;

    @Schema(description = "Минимальная цена")
    private Double minimalPrice;

    public Product(String name, String description, String vendorCode, String externalCode, Long weight, Long volume
            , Double purchasePrice, Double salePrice, Double minimalPrice) {
        this.name = name;
        this.description = description;
        this.vendorCode = vendorCode;
        this.externalCode = externalCode;
        this.weight = weight;
        this.volume = volume;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.minimalPrice = minimalPrice;
    }

    public Product() {

    }
}