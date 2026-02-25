package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class SaleHeaderResponseDTO {
    private Long id;
    private LocalDateTime saleDate;
    private BigDecimal subtotal;
    private BigDecimal totalTax;
    private BigDecimal totalSale;
    private String companyName;
    private String sellerUsername;
    private String buyerFullName;
    private String statusName;
}