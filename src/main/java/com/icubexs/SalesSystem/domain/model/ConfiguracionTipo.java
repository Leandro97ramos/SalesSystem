package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfiguracionTipo {
    private Integer configuracionTipoId;
    private String codigo;
    private String nombre;
    private String estado;
    private Boolean activo;
}
