package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleDetailRequestDTO {
    private Long saleId;
    private Long productId;
    private Long offerId; // Opcional
    private Long taxRateId; // ID de ConfiguracionDet
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal appliedTaxRate; // % al momento de la venta
    private BigDecimal taxAmount;
    private BigDecimal discountAmount;
    private BigDecimal total;
}