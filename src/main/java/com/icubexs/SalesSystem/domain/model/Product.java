package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
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

    // Relaciones con configuración
    private ConfiguracionDet unitMeasure;  // unit_measure_config_det_id
    private ConfiguracionDet taxCategory;  // tax_category_config_det_id
}