package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDTO {
    private String sku;
    private String code;
    private String name;
    private String description;
    private Boolean isSerialized;
    private Boolean appliesTax;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal measureValue;
    private BigDecimal basePrice;
    private Long unitMeasureId;  // ID de ConfiguracionDet
    private Long taxCategoryId;  // ID de ConfiguracionDet
}