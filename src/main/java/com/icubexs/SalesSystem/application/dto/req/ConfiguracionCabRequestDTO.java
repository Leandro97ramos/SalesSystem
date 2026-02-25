package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class ConfiguracionCabRequestDTO {
    private Long configuracionTipoId; // Referencia al ID del tipo
    private String codigo;
    private String nombre;
    private String parametro;
    private String estado;
    private Boolean activo;
}