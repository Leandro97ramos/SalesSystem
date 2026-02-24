package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id;
    private String serialNumber;
    private Product product;           // product_id
    private Batch batch;               // batch_id
    private ConfiguracionDet status;   // status_config_det_id
}

