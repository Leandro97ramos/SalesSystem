package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class CompanyRequestDTO {
    private String taxIdNumber;
    private String legalName;
    private Long parentCompanyId;    // Para estructura jerárquica
    private Long typeConfigurationId; // Tipo de entidad [cite: 76]
}