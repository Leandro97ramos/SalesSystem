package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.ConfiguracionTipo;
import java.util.List;
import java.util.Optional;

public interface ConfiguracionTipoRepository {
    ConfiguracionTipo save(ConfiguracionTipo configuracionTipo);
    List<ConfiguracionTipo> findAll();
    Optional<ConfiguracionTipo> findById(Integer configTipoId);
    Optional<ConfiguracionTipo> findByCodigo(String codigo);
    List<ConfiguracionTipo> findByIniCodigo(String iniCodigo);

}