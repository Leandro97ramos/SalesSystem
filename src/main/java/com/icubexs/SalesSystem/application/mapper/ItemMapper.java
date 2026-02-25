package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.ItemRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.ItemResponseDTO;
import com.icubexs.SalesSystem.domain.model.Batch;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.domain.model.Item;
import com.icubexs.SalesSystem.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public Item toDomain(ItemRequestDTO request) {
        if (request == null) return null;
        return Item.builder()
                .serialNumber(request.getSerialNumber())
                .product(Product.builder().id(request.getProductId()).build())
                .batch(Batch.builder().id(request.getBatchId()).build())
                .status(ConfiguracionDet.builder().id(request.getStatusId()).build())
                .build();
    }

    public ItemResponseDTO toResponse(Item domain) {
        if (domain == null) return null;
        return ItemResponseDTO.builder()
                .id(domain.getId())
                .serialNumber(domain.getSerialNumber())
                .productName(domain.getProduct() != null ? domain.getProduct().getName() : null)
                .batchCode(domain.getBatch() != null ? domain.getBatch().getCode() : null)
                .statusName(domain.getStatus() != null ? domain.getStatus().getNombre() : null)
                .build();
    }
}