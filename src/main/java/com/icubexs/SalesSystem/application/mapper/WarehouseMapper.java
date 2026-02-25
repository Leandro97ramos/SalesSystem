package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.WarehouseRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.WarehouseResponseDTO;
import com.icubexs.SalesSystem.domain.model.*;
import org.springframework.stereotype.Component;

@Component
public class WarehouseMapper {

    public Warehouse toDomain(WarehouseRequestDTO request) {
        if (request == null) return null;

        return Warehouse.builder()
                .name(request.getName())
                .address(request.getAddress())
                .company(Company.builder().id(request.getCompanyId()).build())
                .geoLocation(GeoLocation.builder().id(request.getGeoLocationId()).build())
                .typeConfig(ConfiguracionDet.builder().id(request.getTypeConfigId()).build())
                .parentWarehouse(request.getParentWarehouseId() != null ?
                        Warehouse.builder().id(request.getParentWarehouseId()).build() : null)
                .build();
    }

    public WarehouseResponseDTO toResponse(Warehouse domain) {
        if (domain == null) return null;

        return WarehouseResponseDTO.builder()
                .id(domain.getId())
                .name(domain.getName())
                .address(domain.getAddress())
                .companyName(domain.getCompany() != null ? domain.getCompany().getLegalName() : null)
                .cityName(domain.getGeoLocation() != null ? domain.getGeoLocation().getCityName() : null)
                .typeConfigName(domain.getTypeConfig() != null ? domain.getTypeConfig().getNombre() : null)
                .parentWarehouseName(domain.getParentWarehouse() != null ? domain.getParentWarehouse().getName() : "Nivel Raíz")
                .build();
    }
}