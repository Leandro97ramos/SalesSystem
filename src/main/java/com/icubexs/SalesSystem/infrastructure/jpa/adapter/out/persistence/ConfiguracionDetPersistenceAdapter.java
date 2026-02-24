package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;


import com.icubexs.SalesSystem.application.port.out.ConfiguracionDetRepository;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.ConfiguracionDetJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;



import com.icubexs.SalesSystem.domain.model.ConfiguracionCab;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionCabEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionDetEntity;

import java.util.List;


@Component
@RequiredArgsConstructor
public class ConfiguracionDetPersistenceAdapter implements ConfiguracionDetRepository {

    private final ConfiguracionDetJpaRepository jpaRepository;

    @Override
    public ConfiguracionDet save(ConfiguracionDet domain) {
        ConfiguracionDetEntity entity = toEntity(domain);
        return toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<ConfiguracionDet> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<ConfiguracionDet> findByCodigo(String codigo) {
        return jpaRepository.findByCodigo(codigo).map(this::toDomain);
    }

    @Override
    public List<ConfiguracionDet> findByCabeceraCodigo(String cabeceraCodigo) {
        return jpaRepository.findByCabeceraCodigo(cabeceraCodigo).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConfiguracionDet> findChildrenByPadreId(Long padreId) {
        return jpaRepository.findByPadreId(padreId).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    // --- MÉTODOS DE MAPEO MANUAL ---

    private ConfiguracionDet toDomain(ConfiguracionDetEntity entity) {
        if (entity == null) return null;

        return ConfiguracionDet.builder()
                .id(entity.getId())
                .codigo(entity.getCodigo())
                .nombre(entity.getNombre())
                .parametro(entity.getParametro())
                .estado(entity.getEstado())
                .activo(entity.getActivo())
                // Mapeo de Cabecera (solo datos esenciales para evitar recursividad infinita)
                .cabecera(entity.getCabecera() != null ?
                        ConfiguracionCab.builder()
                                .id(entity.getCabecera().getId())
                                .codigo(entity.getCabecera().getCodigo())
                                .nombre(entity.getCabecera().getNombre())
                                .build() : null)
                // Mapeo de Padre (recursividad manual)
                .padre(entity.getPadre() != null ?
                        ConfiguracionDet.builder().id(entity.getPadre().getId()).build() : null)
                .build();
    }

    private ConfiguracionDetEntity toEntity(ConfiguracionDet domain) {
        if (domain == null) return null;

        ConfiguracionDetEntity entity = ConfiguracionDetEntity.builder()
                .id(domain.getId())
                .codigo(domain.getCodigo())
                .nombre(domain.getNombre())
                .parametro(domain.getParametro())
                .estado(domain.getEstado())
                .activo(domain.getActivo())
                .build();

        // Asignar Cabecera si existe
        if (domain.getCabecera() != null) {
            entity.setCabecera(ConfiguracionCabEntity.builder()
                    .id(domain.getCabecera().getId())
                    .build());
        }

        // Asignar Padre si existe (para la jerarquía padre_configuracion_det_id)
        if (domain.getPadre() != null) {
            entity.setPadre(ConfiguracionDetEntity.builder()
                    .id(domain.getPadre().getId())
                    .build());
        }

        return entity;
    }
}