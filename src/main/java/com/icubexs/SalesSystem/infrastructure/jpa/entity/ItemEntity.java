package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "items")
@Data
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(name = "sku_code", unique = true, nullable = false)
    private String skuCode;

    private String name;
    private String description;

    @Column(name = "unit_measure")
    private String unitMeasure;

    // Dimensiones físicas para el cálculo estilo Amazon
    private Double length;
    private Double width;
    private Double height;
    private Double weight;
}
