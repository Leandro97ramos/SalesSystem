package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.SaleDetailRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.SaleDetailResponseDTO;
import com.icubexs.SalesSystem.domain.model.*;
import org.springframework.stereotype.Component;

@Component
public class SaleDetailMapper {
    public SaleDetail toDomain(SaleDetailRequestDTO request) {
        if (request == null) return null;
        return SaleDetail.builder()
                .quantity(request.getQuantity())
                .unitPrice(request.getUnitPrice())
                .appliedTaxRate(request.getAppliedTaxRate())
                .taxAmount(request.getTaxAmount())
                .discountAmount(request.getDiscountAmount())
                .total(request.getTotal())
                .sale(SaleHeader.builder().id(request.getSaleId()).build())
                .product(Product.builder().id(request.getProductId()).build())
                .offer(request.getOfferId() != null ? Offer.builder().id(request.getOfferId()).build() : null)
                .taxRate(ConfiguracionDet.builder().id(request.getTaxRateId()).build())
                .build();
    }

    public SaleDetailResponseDTO toResponse(SaleDetail domain) {
        if (domain == null) return null;
        return SaleDetailResponseDTO.builder()
                .id(domain.getId())
                .productName(domain.getProduct() != null ? domain.getProduct().getName() : null)
                .offerName(domain.getOffer() != null ? domain.getOffer().getName() : "Sin Oferta")
                .taxRateName(domain.getTaxRate() != null ? domain.getTaxRate().getNombre() : null)
                .quantity(domain.getQuantity())
                .unitPrice(domain.getUnitPrice())
                .taxAmount(domain.getTaxAmount())
                .discountAmount(domain.getDiscountAmount())
                .total(domain.getTotal())
                .build();
    }
}