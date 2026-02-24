package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.ConfiguracionCab;
import java.util.List;
import java.util.Optional;

public interface ConfiguracionCabRepository {
    ConfiguracionCab save(ConfiguracionCab cabecera);
    Optional<ConfiguracionCab> findById(Long id);
    Optional<ConfiguracionCab> findByCodigo(String codigo);
    List<ConfiguracionCab> findByTipoId(Long tipoId);
}