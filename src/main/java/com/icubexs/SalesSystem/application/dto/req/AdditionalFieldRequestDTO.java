package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class AdditionalFieldRequestDTO {
    private String name;
    private String description;
    private String attribute;     // JSON con validaciones [cite: 165]
    private Long dataSourceId;    // Origen del dato (Producto, Lote, etc) [cite: 161]
    private Long dataTypeId;      // Tipo (Texto, Número, etc) [cite: 162]
}