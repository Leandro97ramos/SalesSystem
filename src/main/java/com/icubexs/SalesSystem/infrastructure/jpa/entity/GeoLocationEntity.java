package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "geo_location")
@Getter
@Setter
@NoArgsConstructor

@AllArgsConstructor
@Builder
public class GeoLocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name", length = 100)
    private String cityName;

    @Column(name = "region_country", length = 100, nullable = false)
    private String regionCountry;

    @Column(name = "postal_code", length = 20)
    private String postalCode;
}