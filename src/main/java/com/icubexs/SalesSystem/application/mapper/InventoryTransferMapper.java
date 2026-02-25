package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.InventoryTransferRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.InventoryTransferResponseDTO;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.domain.model.InventoryTransfer;
import com.icubexs.SalesSystem.domain.model.User;
import com.icubexs.SalesSystem.domain.model.Warehouse;
import org.springframework.stereotype.Component;

@Component
public class InventoryTransferMapper {
    public InventoryTransfer toDomain(InventoryTransferRequestDTO request) {
        if (request == null) return null;
        return InventoryTransfer.builder()
                .sourceWarehouse(Warehouse.builder().id(request.getSourceWarehouseId()).build())
                .destinationWarehouse(Warehouse.builder().id(request.getDestinationWarehouseId()).build())
                .user(User.builder().id(request.getUserId()).build())
                .description(request.getDescription())
                .status(ConfiguracionDet.builder().id(request.getStatusId()).build())
                .build();
    }

    public InventoryTransferResponseDTO toResponse(InventoryTransfer domain) {
        if (domain == null) return null;
        return InventoryTransferResponseDTO.builder()
                .id(domain.getId())
                .sourceWarehouseName(domain.getSourceWarehouse() != null ? domain.getSourceWarehouse().getName() : null)
                .destinationWarehouseName(domain.getDestinationWarehouse() != null ? domain.getDestinationWarehouse().getName() : null)
                .userName(domain.getUser() != null ? domain.getUser().getUsername() : null)
                .transferDate(domain.getTransferDate())
                .description(domain.getDescription())
                .statusName(domain.getStatus() != null ? domain.getStatus().getNombre() : null)
                .build();
    }
}