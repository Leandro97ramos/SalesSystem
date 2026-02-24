package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "configuracion_tipo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfiguracionTipoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "configuracion_tipo_id")
    private Long id;

    @Column(unique = true, length = 100)
    private String codigo;

    private String nombre;
    private String estado;

    @Builder.Default
    private Boolean activo = true;
}