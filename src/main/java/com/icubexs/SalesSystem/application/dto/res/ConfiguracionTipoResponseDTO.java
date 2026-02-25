package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConfiguracionTipoResponseDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private Boolean activo;
}