package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyResponseDTO {
    private Long id;
    private String taxIdNumber;
    private String legalName;
    private String parentCompanyName;
    private String typeConfigurationName;
}