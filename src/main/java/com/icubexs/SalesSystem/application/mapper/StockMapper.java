package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.StockRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.StockResponseDTO;
import com.icubexs.SalesSystem.domain.model.Stock;
import org.springframework.stereotype.Component;



@Component
public class StockMapper {
    public Stock toDomain(StockRequestDTO request) {
        if (request == null) return null;
        return Stock.builder()
                .currentQuantity(request.getCurrentQuantity())
                .reservedQuantity(request.getReservedQuantity())
                .build();
    }

    public StockResponseDTO toResponse(Stock domain) {
        if (domain == null) return null;
        return StockResponseDTO.builder()
                .id(domain.getId())
                .currentQuantity(domain.getCurrentQuantity())
                .reserved_quantity(domain.getReservedQuantity())
                .build();
    }
}
