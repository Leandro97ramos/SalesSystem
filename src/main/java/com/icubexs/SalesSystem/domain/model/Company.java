package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private Long id;
    private String taxIdNumber; // Identificación fiscal (NIT, RUT, CUIT, etc.)
    private String legalName;   // Nombre legal o razón social
    private Company parentCompany; // Relación recursiva para sucursales
    private ConfiguracionDet typeConfiguration; // Tipo de empresa (S.A., S.R.L., etc.)
}
