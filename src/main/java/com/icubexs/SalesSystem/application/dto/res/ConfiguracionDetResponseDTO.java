package com.icubexs.SalesSystem.application.dto.res;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConfiguracionDetResponseDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private String parametro;
    private Boolean activo;
    private Long padreId;      // Referencia al ID del padre por la recursividad
    private String cabeceraNombre; // Nombre de la cabecera vinculada
}