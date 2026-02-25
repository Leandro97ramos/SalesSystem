package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class InventoryTransferResponseDTO {
    private Long id;
    private String sourceWarehouseName;
    private String destinationWarehouseName;
    private String userName;
    private LocalDateTime transferDate;
    private String description;
    private String statusName;
}