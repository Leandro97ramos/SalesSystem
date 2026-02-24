package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.WarehouseRepository;
import com.icubexs.SalesSystem.domain.model.*;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.*;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.WarehouseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WarehousePersistenceAdapter implements WarehouseRepository {

    private final WarehouseJpaRepository jpaRepository;

    @Override
    public Warehouse save(Warehouse domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<Warehouse> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Warehouse> findAll() {
        return jpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Warehouse> findByCompanyId(Long companyId) {
        return jpaRepository.findByCompanyId(companyId).stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private Warehouse toDomain(WarehouseEntity entity) {
        if (entity == null) return null;
        return Warehouse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .company(entity.getCompany() != null ? Company.builder().id(entity.getCompany().getId()).build() : null)
                .geoLocation(entity.getGeoLocation() != null ? GeoLocation.builder().id(entity.getGeoLocation().getId()).build() : null)
                .parentWarehouse(entity.getParentWarehouse() != null ? Warehouse.builder().id(entity.getParentWarehouse().getId()).build() : null)
                .typeConfig(entity.getTypeConfig() != null ? ConfiguracionDet.builder().id(entity.getTypeConfig().getId()).build() : null)
                .build();
    }

    private WarehouseEntity toEntity(Warehouse domain) {
        if (domain == null) return null;
        return WarehouseEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .address(domain.getAddress())
                .company(domain.getCompany() != null ? CompanyEntity.builder().id(domain.getCompany().getId()).build() : null)
                .geoLocation(domain.getGeoLocation() != null ? GeoLocationEntity.builder().id(domain.getGeoLocation().getId()).build() : null)
                .parentWarehouse(domain.getParentWarehouse() != null ? WarehouseEntity.builder().id(domain.getParentWarehouse().getId()).build() : null)
                .typeConfig(domain.getTypeConfig() != null ? ConfiguracionDetEntity.builder().id(domain.getTypeConfig().getId()).build() : null)
                .build();
    }
}