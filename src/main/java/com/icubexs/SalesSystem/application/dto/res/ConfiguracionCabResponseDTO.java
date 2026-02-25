package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConfiguracionCabResponseDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private String parametro;
    private Boolean activo;
    private String tipoNombre; // Aplanado para mostrar el nombre del tipo

}