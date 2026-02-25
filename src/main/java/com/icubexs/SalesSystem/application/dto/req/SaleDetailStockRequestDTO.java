package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleDetailStockRequestDTO {
    private Long saleDetailId;
    private Long stockId;
    private Long itemId; // Solo para productos seriados
    private BigDecimal quantity;
}