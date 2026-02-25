package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.SaleDetailStockRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.SaleDetailStockResponseDTO;
import com.icubexs.SalesSystem.domain.model.Item;
import com.icubexs.SalesSystem.domain.model.SaleDetail;
import com.icubexs.SalesSystem.domain.model.SaleDetailStock;
import com.icubexs.SalesSystem.domain.model.Stock;
import org.springframework.stereotype.Component;

@Component
public class SaleDetailStockMapper {
    public SaleDetailStock toDomain(SaleDetailStockRequestDTO request) {
        if (request == null) return null;
        return SaleDetailStock.builder()
                .saleDetail(SaleDetail.builder().id(request.getSaleDetailId()).build())
                .stock(Stock.builder().id(request.getStockId()).build())
                .item(request.getItemId() != null ? Item.builder().id(request.getItemId()).build() : null)
                .quantity(request.getQuantity())
                .build();
    }

    public SaleDetailStockResponseDTO toResponse(SaleDetailStock domain) {
        if (domain == null) return null;
        return SaleDetailStockResponseDTO.builder()
                .id(domain.getId())
                .saleDetailId(domain.getSaleDetail() != null ? domain.getSaleDetail().getId() : null)
                .stockId(domain.getStock() != null ? domain.getStock().getId() : null)
                .serialNumber(domain.getItem() != null ? domain.getItem().getSerialNumber() : "N/A")
                .quantity(domain.getQuantity())
                .build();
    }
}