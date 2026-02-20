package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private Long companyId;
    private String legalName;
    private String taxId;
    private String globalConfig;
}
