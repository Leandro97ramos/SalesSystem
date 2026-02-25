package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class BatchResponseDTO {
    private Long id;
    private String productName; // Aplanado para el front
    private String companyName;
    private String code;
    private String invoiceNumber;
    private Integer initialQuantity;
    private Integer currentQuantity;
    private LocalDateTime entryDate;
    private LocalDateTime expirationDate;
    private BigDecimal unitCost;
}

