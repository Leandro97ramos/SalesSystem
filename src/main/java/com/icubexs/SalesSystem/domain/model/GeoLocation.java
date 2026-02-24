package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeoLocation {
    private Long id;
    private String cityName;
    private String regionCountry; // Corresponde al campo NOT NULL en el SQL
    private String postalCode;
}