package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyInfo {
    private Long id;
    private Long companyId; // ID de la empresa a la que pertenece.
    private String value;   // Valor del campo dinámico.
    private AdditionalField additionalField; // El "qué" es este dato
}