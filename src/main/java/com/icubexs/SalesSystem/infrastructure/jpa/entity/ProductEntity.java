package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String sku;

    @Column(length = 100)
    private String code;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_serialized")
    private Boolean isSerialized;

    @Column(name = "applies_tax")
    private Boolean appliesTax;

    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;

    @Column(name = "measure_value")
    private BigDecimal measureValue;

    @Column(name = "base_price", nullable = false)
    private BigDecimal basePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_measure_config_det_id")
    private ConfiguracionDetEntity unitMeasure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tax_category_config_det_id")
    private ConfiguracionDetEntity taxCategory;
}