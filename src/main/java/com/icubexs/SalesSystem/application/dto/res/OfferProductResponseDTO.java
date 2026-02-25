package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OfferProductResponseDTO {
    private Long id;
    private String offerName;
    private String productName;
    private String productSku;
}