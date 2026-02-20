package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {
    private Long warehouseId; // Identificador único del almacén real
    private Long companyId; // Vínculo con la empresa propietaria
    private Long locationId; // Ubicación geográfica vinculada al catálogo
    private Long configHeaderId; // Relación con la cabecera de configuración
    private String name; // Nombre de la bodega [cite: 81]
    private String address; // Dirección operativa
}