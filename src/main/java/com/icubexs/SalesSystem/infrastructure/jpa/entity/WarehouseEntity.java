package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "warehouse")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "geo_location_id")
    private GeoLocationEntity geoLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_warehouse_id")
    private WarehouseEntity parentWarehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_configuration_det_id")
    private ConfiguracionDetEntity typeConfig;
}