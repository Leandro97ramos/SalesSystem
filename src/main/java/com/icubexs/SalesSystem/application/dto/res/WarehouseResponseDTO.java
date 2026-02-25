package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WarehouseResponseDTO {
    private Long id;
    private String name;
    private String address;
    private String companyName;
    private String cityName;           // Desde GeoLocation
    private String parentWarehouseName; // Nombre de la bodega padre
    private String typeConfigName;      // Ej: "Cámara de Frío"
}