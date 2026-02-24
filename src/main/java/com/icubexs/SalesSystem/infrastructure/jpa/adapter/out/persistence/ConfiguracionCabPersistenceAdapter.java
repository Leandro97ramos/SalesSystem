package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.ConfiguracionCabRepository; // EL IMPORT QUE FALTA
import com.icubexs.SalesSystem.domain.model.ConfiguracionCab;
import com.icubexs.SalesSystem.domain.model.ConfiguracionTipo;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionCabEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionTipoEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.ConfiguracionCabJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class ConfiguracionCabPersistenceAdapter implements ConfiguracionCabRepository {

    private final ConfiguracionCabJpaRepository jpaRepository;

    @Override
    public ConfiguracionCab save(ConfiguracionCab domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<ConfiguracionCab> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ConfiguracionCab> findByCodigo(String codigo) {
        return jpaRepository.findByCodigo(codigo).map(this::toDomain);
    }

    @Override
    public List<ConfiguracionCab> findByTipoId(Long tipoId) {
        return List.of();
    }

    // --- MÉTODOS DE MAPEO MANUAL ---
    private ConfiguracionCab toDomain(ConfiguracionCabEntity entity) {
        if (entity == null) return null;
        return ConfiguracionCab.builder()
                .id(entity.getId())
                .codigo(entity.getCodigo())
                .nombre(entity.getNombre())
                .parametro(entity.getParametro())
                .estado(entity.getEstado())
                .activo(entity.getActivo())
                // Mapeo anidado manual
                .configuracionTipo(ConfiguracionTipo.builder()
                        .id(entity.getTipo().getId())
                        .codigo(entity.getTipo().getCodigo())
                        .build())
                .build();
    }

    private ConfiguracionCabEntity toEntity(ConfiguracionCab domain) {
        if (domain == null) return null;
        return ConfiguracionCabEntity.builder()
                .id(domain.getId())
                .codigo(domain.getCodigo())
                .nombre(domain.getNombre())
                .parametro(domain.getParametro())
                .estado(domain.getEstado())
                .activo(domain.getActivo())
                // Mapeo anidado manual hacia la entidad
                .tipo(ConfiguracionTipoEntity.builder().id(domain.getConfiguracionTipo().getId()).build())
                .build();
    }
}