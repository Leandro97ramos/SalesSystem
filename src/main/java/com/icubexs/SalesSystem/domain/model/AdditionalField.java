package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalField {
    private Long id;
    private String name;
    private String description;
    private String attribute; // Para almacenar configuraciones extra en formato JSON
    private ConfiguracionDet dataSource; // Relación con el origen de datos
    private ConfiguracionDet dataType;   // Relación con el tipo de dato (String, Number, etc).
}