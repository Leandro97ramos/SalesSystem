package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.ConfiguracionTipo;

import java.util.List;
import java.util.Optional;

public interface ConfiguracionTipoService {
    ConfiguracionTipo create(ConfiguracionTipo tipo);
    Optional<ConfiguracionTipo> findByCodigo(String codigo);
    List<ConfiguracionTipo> findAllActive();
}