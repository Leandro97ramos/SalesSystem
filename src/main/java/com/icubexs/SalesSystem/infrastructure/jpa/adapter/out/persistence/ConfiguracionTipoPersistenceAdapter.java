package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.domain.model.ConfiguracionTipo;
import com.icubexs.SalesSystem.application.port.out.ConfiguracionTipoRepository;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionTipoEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.ConfiguracionTipoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ConfiguracionTipoPersistenceAdapter implements ConfiguracionTipoRepository {

    private final ConfiguracionTipoJpaRepository jpaRepository;

    @Override
    public ConfiguracionTipo save(ConfiguracionTipo domain) {
        ConfiguracionTipoEntity entity = toEntity(domain);
        return toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<ConfiguracionTipo> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ConfiguracionTipo> findByCodigo(String codigo) {
        return jpaRepository.findByCodigo(codigo).map(this::toDomain);
    }

    @Override
    public List<ConfiguracionTipo> findAllActive() {
        return jpaRepository.findByActivoTrue().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    // --- MÉTODOS DE MAPEO MANUAL ---
    private ConfiguracionTipo toDomain(ConfiguracionTipoEntity entity) {
        if (entity == null) return null;
        return ConfiguracionTipo.builder()
                .id(entity.getId())
                .codigo(entity.getCodigo())
                .nombre(entity.getNombre())
                .estado(entity.getEstado())
                .activo(entity.getActivo())
                .build();
    }

    private ConfiguracionTipoEntity toEntity(ConfiguracionTipo domain) {
        if (domain == null) return null;
        return ConfiguracionTipoEntity.builder()
                .id(domain.getId())
                .codigo(domain.getCodigo())
                .nombre(domain.getNombre())
                .estado(domain.getEstado())
                .activo(domain.getActivo())
                .build();
    }
}