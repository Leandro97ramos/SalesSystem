package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class ItemRequestDTO {
    private String serialNumber;
    private Long productId;
    private Long batchId;
    private Long statusId; // ID de ConfiguracionDet
}