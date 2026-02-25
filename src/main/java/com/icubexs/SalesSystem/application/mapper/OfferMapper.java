package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.OfferRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.OfferResponseDTO;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.domain.model.Offer;
import org.springframework.stereotype.Component;

@Component
public class OfferMapper {
    public Offer toDomain(OfferRequestDTO request) {
        if (request == null) return null;
        return Offer.builder()
                .name(request.getName())
                .description(request.getDescription())
                .discountValue(request.getDiscountValue())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .isActive(request.getIsActive())
                .discountType(ConfiguracionDet.builder().id(request.getDiscountTypeId()).build())
                .build();
    }

    public OfferResponseDTO toResponse(Offer domain) {
        if (domain == null) return null;
        return OfferResponseDTO.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .discountValue(domain.getDiscountValue())
                .startDate(domain.getStartDate())
                .endDate(domain.getEndDate())
                .isActive(domain.getIsActive())
                .discountTypeName(domain.getDiscountType() != null ? domain.getDiscountType().getNombre() : null)
                .build();
    }
}