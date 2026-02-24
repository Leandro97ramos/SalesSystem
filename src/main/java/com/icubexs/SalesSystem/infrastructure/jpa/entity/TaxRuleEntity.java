package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tax_rule")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TaxRuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "geo_location_id")
    private GeoLocationEntity geoLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tax_category_config_det_id")
    private ConfiguracionDetEntity taxCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tax_value_config_det_id")
    private ConfiguracionDetEntity taxValue;
}