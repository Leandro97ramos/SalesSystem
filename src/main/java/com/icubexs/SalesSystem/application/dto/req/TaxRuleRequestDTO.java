package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class TaxRuleRequestDTO {
    private Long geoLocationId;
    private Long taxCategoryId;
    private Long taxValueId; // El % de impuesto como ConfiguracionDet
}