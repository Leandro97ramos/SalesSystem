package com.icubexs.SalesSystem.infrastructure.jpa.entity;


import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;


public class ProductImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product; // Relación con ProductEntity

    @Column(nullable = false)
    private String url; // URL de la imagen

    @Column(nullable = false)
    private Boolean isPrimary; // Indica si es la imagen principal

    @Column(nullable = false)
    private Integer orderIndex; // Índice para ordenar las imágenes


}
