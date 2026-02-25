package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.ProductRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.ProductResponseDTO;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toDomain(ProductRequestDTO request) {
        if (request == null) return null;
        return Product.builder()
                .sku(request.getSku()).code(request.getCode()).name(request.getName())
                .description(request.getDescription()).isSerialized(request.getIsSerialized())
                .appliesTax(request.getAppliesTax()).length(request.getLength())
                .width(request.getWidth()).height(request.getHeight())
                .measureValue(request.getMeasureValue()).basePrice(request.getBasePrice())
                .unitMeasure(ConfiguracionDet.builder().id(request.getUnitMeasureId()).build())
                .taxCategory(ConfiguracionDet.builder().id(request.getTaxCategoryId()).build())
                .build();
    }

    public ProductResponseDTO toResponse(Product domain) {
        if (domain == null) return null;
        return ProductResponseDTO.builder()
                .id(domain.getId()).sku(domain.getSku()).name(domain.getName())
                .description(domain.getDescription()).isSerialized(domain.getIsSerialized())
                .basePrice(domain.getBasePrice())
                .unitMeasureName(domain.getUnitMeasure() != null ? domain.getUnitMeasure().getNombre() : null)
                .taxCategoryName(domain.getTaxCategory() != null ? domain.getTaxCategory().getNombre() : null)
                .build();
    }
}