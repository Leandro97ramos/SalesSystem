package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SaleDetailResponseDTO {
    private Long id;
    private String productName;
    private String offerName;
    private String taxRateName;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal taxAmount;
    private BigDecimal discountAmount;
    private BigDecimal total;
}