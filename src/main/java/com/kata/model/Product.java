package com.kata.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "products")
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private static final boolean ISPRODUCT = true;
    private String description;
    private String vendorCode;
    private String externalCode;
    private Long weight;
    private Long volume;

    public Product(String name, String description, String vendorCode, String externalCode, Long weight, Long volume) {
        this.name = name;
        this.description = description;
        this.vendorCode = vendorCode;
        this.externalCode = externalCode;
        this.weight = weight;
        this.volume = volume;
    }

    public Product() {

    }
}
