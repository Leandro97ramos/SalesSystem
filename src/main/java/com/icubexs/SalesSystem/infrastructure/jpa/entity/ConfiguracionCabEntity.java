package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "configuracion_cab")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfiguracionCabEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "configuracion_cab_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "configuracion_tipo_id")
    private ConfiguracionTipoEntity tipo;

    @Column(unique = true, length = 100)
    private String codigo;

    private String nombre;
    private String parametro;
    private String estado;

    @Builder.Default
    private Boolean activo = true;
}