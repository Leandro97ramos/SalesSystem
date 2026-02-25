package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class ConfiguracionDetRequestDTO {
    private Long cabeceraId;
    private Long padreId;
    private String codigo;
    private String nombre;
    private String parametro;
    private String estado;
    private Boolean activo;
}