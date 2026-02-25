package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class CompanyInfoRequestDTO {
    private Long companyId;
    private Long additionalFieldId;
    private String value;
}