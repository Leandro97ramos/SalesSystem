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
        ConfiguracionTipoEntity entity = new ConfiguracionTipoEntity();
        entity.setConfiguracionTipoId(domain.getConfiguracionTipoId());
        entity.setCodigo(domain.getCodigo());
        entity.setNombre(domain.getNombre());
        entity.setEstado(domain.getEstado());
        entity.setActivo(domain.getActivo());

        ConfiguracionTipoEntity saved = jpaRepository.save(entity);
        return mapToDomain(saved);
    }

    @Override
    public List<ConfiguracionTipo> findAll() {
        return jpaRepository.findAll().stream().map(this::mapToDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<ConfiguracionTipo> findById(Integer id) {
        return jpaRepository.findById(id).map(this::mapToDomain);
    }

    @Override
    public Optional<ConfiguracionTipo> findByCodigo(String codigo) {
        return jpaRepository.findByCodigo(codigo).map(this::mapToDomain);
    }

    @Override
    public List<ConfiguracionTipo> findByIniCodigo(String iniCodigo) {
        return jpaRepository.findByCodigoStartingWith(iniCodigo).stream()
                .map(this::mapToDomain).collect(Collectors.toList());
    }

    private ConfiguracionTipo mapToDomain(ConfiguracionTipoEntity entity) {
        return ConfiguracionTipo.builder()
                .configuracionTipoId(entity.getConfiguracionTipoId())
                .codigo(entity.getCodigo())
                .nombre(entity.getNombre())
                .estado(entity.getEstado())
                .activo(entity.getActivo())
                .build();
    }
}