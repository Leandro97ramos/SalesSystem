package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfiguracionCab {
    private Long id;
    private ConfiguracionTipo configuracionTipo; // Relación con el tipo
    private String codigo;
    private String nombre;
    private String parametro;
    private String estado;
    private Boolean activo;
}