package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.OfferProductRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.OfferProductResponseDTO;
import com.icubexs.SalesSystem.domain.model.Offer;
import com.icubexs.SalesSystem.domain.model.OfferProduct;
import com.icubexs.SalesSystem.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public class OfferProductMapper {
    public OfferProduct toDomain(OfferProductRequestDTO request) {
        if (request == null) return null;
        return OfferProduct.builder()
                .offer(Offer.builder().id(request.getOfferId()).build())
                .product(Product.builder().id(request.getProductId()).build())
                .build();
    }

    public OfferProductResponseDTO toResponse(OfferProduct domain) {
        if (domain == null) return null;
        return OfferProductResponseDTO.builder()
                .id(domain.getId())
                .offerName(domain.getOffer() != null ? domain.getOffer().getName() : null)
                .productName(domain.getProduct() != null ? domain.getProduct().getName() : null)
                .productSku(domain.getProduct() != null ? domain.getProduct().getSku() : null)
                .build();
    }
}