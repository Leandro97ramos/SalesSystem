package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class WarehouseRequestDTO {
    private String name;
    private String address;
    private Long companyId;
    private Long geoLocationId;
    private Long parentWarehouseId; // Opcional, para la jerarquía
    private Long typeConfigId;      // ID de ConfiguracionDet (ej: "Principal", "Sub-bodega")
}