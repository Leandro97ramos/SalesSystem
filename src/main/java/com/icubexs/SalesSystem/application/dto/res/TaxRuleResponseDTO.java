package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaxRuleResponseDTO {
    private Long id;
    private String cityName;
    private String taxCategoryName;
    private String taxValueName; // Ej: "IVA 21%"
}