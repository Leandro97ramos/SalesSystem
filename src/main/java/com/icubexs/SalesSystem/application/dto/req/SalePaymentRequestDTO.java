package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SalePaymentRequestDTO {
    private Long saleId;
    private Long paymentMethodId; // ID de ConfiguracionDet (Efectivo, Tarjeta, etc.)
    private BigDecimal amountPaid;
    private String transactionReference;
}