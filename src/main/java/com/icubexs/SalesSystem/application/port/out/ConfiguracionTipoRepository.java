package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.ConfiguracionTipo;
import java.util.List;
import java.util.Optional;

public interface ConfiguracionTipoRepository {
    ConfiguracionTipo save(ConfiguracionTipo tipo);
    Optional<ConfiguracionTipo> findById(Long id);
    Optional<ConfiguracionTipo> findByCodigo(String codigo);
    List<ConfiguracionTipo> findAllActive();

}