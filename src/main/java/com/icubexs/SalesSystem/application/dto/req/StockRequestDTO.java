package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class StockRequestDTO {
    private Long batchId;
    private Long productId;
    private Long locationId; // ID de ConfiguracionDet (Bodega/Estante)
    private Integer currentQuantity;
}