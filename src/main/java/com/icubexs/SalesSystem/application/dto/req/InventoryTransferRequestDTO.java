package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class InventoryTransferRequestDTO {
    private Long sourceWarehouseId;
    private Long destinationWarehouseId;
    private Long userId;
    private String description;
    private Long statusId; // ID de ConfiguracionDet (ej: "En Tránsito")
}