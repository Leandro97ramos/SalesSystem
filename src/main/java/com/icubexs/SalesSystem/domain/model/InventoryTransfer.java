package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryTransfer {
    private Long id;
    private Warehouse sourceWarehouse;      // source_warehouse_id
    private Warehouse destinationWarehouse; // destination_warehouse_id
    private User user;                      // user_id
    private LocalDateTime transferDate;
    private String description;
    private ConfiguracionDet status;        // status_config_det_id
}