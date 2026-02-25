package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class ConfiguracionTipoRequestDTO {
    private String codigo;
    private String nombre;
    private String estado;
    private Boolean activo;
}