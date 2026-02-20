package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "configuracion_tipo")
@Data
public class ConfiguracionTipoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer configuracionTipoId;
    private String codigo;
    private String nombre;
    private String estado;
    private Boolean activo;
}