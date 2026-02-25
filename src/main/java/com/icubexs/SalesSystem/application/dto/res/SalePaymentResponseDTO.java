package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SalePaymentResponseDTO {
    private Long id;
    private Long saleId;
    private String paymentMethodName;
    private BigDecimal amountPaid;
    private String transactionReference;
}