package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class GeoLocationRequestDTO {
    private String cityName;
    private String regionCountry;
    private String postalCode;
}