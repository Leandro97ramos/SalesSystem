package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeoLocationResponseDTO {
    private Long id;
    private String cityName;
    private String regionCountry;
    private String postalCode;
}