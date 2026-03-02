package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class PersonRequestDTO {
    private String firstName;
    private String lastName;
    private String identification; // DNI/Cédula [cite: 56]
    private String phone;
    private String personalAddress;
    private Long geoLocationId; // Foreign key to GeoLocation
}