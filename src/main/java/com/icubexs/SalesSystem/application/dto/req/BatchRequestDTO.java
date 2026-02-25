package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BatchRequestDTO {
    private Long productId;
    private Long companyId;
    private String code;
    private String invoiceNumber;
    private Integer initialQuantity;
    private Integer currentQuantity;
    private LocalDateTime entryDate;
    private LocalDateTime expirationDate;
    private BigDecimal unitCost;
}