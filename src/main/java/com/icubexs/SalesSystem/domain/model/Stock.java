package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    private Long id;
    private Batch batch;                  // batch_id
    private Product product;              // product_id
    private ConfiguracionDet location;    // location_config_det_id
    private Integer currentQuantity;      // current_quantity
}