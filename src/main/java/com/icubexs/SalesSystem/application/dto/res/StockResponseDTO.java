package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockResponseDTO {
    private Long id;
    private String batchCode;
    private String productName;
    private String locationName;
    private Integer currentQuantity;
}