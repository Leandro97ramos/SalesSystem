package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BatchInfoResponseDTO {
    private Long id;
    private Long batchId;
    private String value;
    private String fieldName; // ej: "Fecha de Vencimiento Interna"
}