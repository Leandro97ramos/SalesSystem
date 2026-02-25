package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdditionalFieldResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String attribute;
    private String dataSourceName;
    private String dataTypeName;
}