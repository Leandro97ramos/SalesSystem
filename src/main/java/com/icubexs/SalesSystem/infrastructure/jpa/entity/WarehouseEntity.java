package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "warehouses")
@Data
public class WarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warehouseId;

    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Column(name = "location_id", nullable = false)
    private Long locationId;

    @Column(name = "config_header_id", nullable = false)
    private Long configHeaderId;
    /*id_configuracion_cab
    * configuracion_det_id
    * */

    private String name;
    private String address;
}