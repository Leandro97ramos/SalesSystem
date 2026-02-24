package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaxRule {
    private Long id;
    private GeoLocation geoLocation;          // geo_location_id
    private ConfiguracionDet taxCategory;     // tax_category_config_det_id
    private ConfiguracionDet taxValue;        // tax_value_config_det_id
}