package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.ConfiguracionTipo;

import java.util.List;

public interface ConfiguracionTipoService {
    ConfiguracionTipo create(ConfiguracionTipo request);
    List<ConfiguracionTipo> getAll();
    ConfiguracionTipo getById(Integer configTipoId);
    String getNuevoCodigo(String inicial);
}