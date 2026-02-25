package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

// Response
@Data
@Builder
public class ProductResponseDTO {
    private Long id;
    private String sku;
    private String name;
    private String description;
    private Boolean isSerialized;
    private BigDecimal basePrice;
    private String unitMeasureName; // Nombre de la unidad (ej: "Unidad", "Kg")
    private String taxCategoryName; // Nombre de la categoría (ej: "IVA 21%")
}

