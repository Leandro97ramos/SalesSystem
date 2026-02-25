package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductInfoResponseDTO {
    private Long id;
    private Long productId;
    private String fieldName; // Nombre del campo (ej: "Voltaje") [cite: 145]
    private String value;     // Valor real (ej: "110V") [cite: 145]
}