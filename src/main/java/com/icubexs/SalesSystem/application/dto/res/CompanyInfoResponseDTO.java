package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyInfoResponseDTO {
    private Long id;
    private Long companyId;
    private String value;
    private String fieldName; // ej: "Horario de Atención"
}

