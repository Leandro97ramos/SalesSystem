package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.ProductInfoRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.ProductInfoResponseDTO;
import com.icubexs.SalesSystem.domain.model.AdditionalField;
import com.icubexs.SalesSystem.domain.model.ProductInfo;
import org.springframework.stereotype.Component;

@Component
public class ProductInfoMapper {
    public ProductInfo toDomain(ProductInfoRequestDTO request) {
        if (request == null) return null;
        return ProductInfo.builder()
                .productId(request.getProductId())
                .value(request.getValue())
                .additionalField(AdditionalField.builder().id(request.getAdditionalFieldId()).build())
                .build();
    }

    public ProductInfoResponseDTO toResponse(ProductInfo domain) {
        if (domain == null) return null;
        return ProductInfoResponseDTO.builder()
                .id(domain.getId())
                .productId(domain.getProductId())
                .value(domain.getValue())
                .fieldName(domain.getAdditionalField() != null ? domain.getAdditionalField().getName() : null)
                .build();
    }
}