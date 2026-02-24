package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Batch {
    private Long id;
    private Product product;          // product_id
    private Company company;          // company_id
    private String code;
    private String invoiceNumber;
    private Integer initialQuantity;
    private Integer currentQuantity;
    private LocalDateTime entryDate;
    private LocalDateTime expirationDate;
    private BigDecimal unitCost;
}