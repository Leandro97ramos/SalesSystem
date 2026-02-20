package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfiguracionDet {
    private Integer configuracionDetId;
    private Integer padreConfiguracionDetId;
    private ConfiguracionCab configuracionCab; // Relación con la cabecera
    private String codigo;
    private String nombre;
    private String parametro;
    private String estado;
    private Boolean activo;
}