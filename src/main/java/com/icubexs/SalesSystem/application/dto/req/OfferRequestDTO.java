package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OfferRequestDTO {
    private String name;
    private String description;
    private BigDecimal discountValue;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean isActive;
    private Long discountTypeId; // ID de ConfiguracionDet
}