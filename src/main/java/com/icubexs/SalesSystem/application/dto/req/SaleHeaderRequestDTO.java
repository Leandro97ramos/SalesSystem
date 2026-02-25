package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleHeaderRequestDTO {
    private Long companyId;
    private Long sellerId;
    private Long buyerId;
    private Long statusId; // ID de ConfiguracionDet (Pendiente, Pagada)
    private BigDecimal subtotal;
    private BigDecimal totalTax;
    private BigDecimal totalSale;
}