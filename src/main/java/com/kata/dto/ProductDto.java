package com.kata.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;

    @Schema(description = "Наименование товара")
    private String name;

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

    @Schema(description = "Цена продажи")
    private Double salePrice;

}
