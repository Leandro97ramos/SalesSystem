package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {
    private Long id;
    private String name;
    private String address;
    private Company company;               // company_id
    private GeoLocation geoLocation;       // geo_location_id
    private Warehouse parentWarehouse;      // parent_warehouse_id (recursivo)
    private ConfiguracionDet typeConfig;   // parent_configuration_det_id (Ej: Principal, Secundario)
}