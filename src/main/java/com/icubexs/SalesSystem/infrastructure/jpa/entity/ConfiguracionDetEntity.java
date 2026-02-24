package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "configuracion_det")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfiguracionDetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "configuracion_det_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "padre_configuracion_det_id")
    private ConfiguracionDetEntity padre; // Relación recursiva

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "configuracion_cab_id")
    private ConfiguracionCabEntity cabecera;

    @Column(unique = true, length = 100)
    private String codigo;

    private String nombre;

    @Column(length = 5000)
    private String parametro;

    private String estado;

    @Builder.Default
    private Boolean activo = true;
}