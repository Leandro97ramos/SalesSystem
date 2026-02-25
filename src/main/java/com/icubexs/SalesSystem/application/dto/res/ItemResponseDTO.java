package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

// Response
@Data
@Builder
public class ItemResponseDTO {
    private Long id;
    private String serialNumber;
    private String productName;
    private String batchCode;
    private String statusName;
}