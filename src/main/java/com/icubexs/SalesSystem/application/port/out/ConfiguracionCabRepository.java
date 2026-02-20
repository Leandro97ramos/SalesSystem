package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.ConfiguracionCab;
import java.util.List;
import java.util.Optional;

public interface ConfiguracionCabRepository {
    ConfiguracionCab save(ConfiguracionCab configuracionCab);
    Optional<ConfiguracionCab> findById (Integer configCabId);
    Optional<ConfiguracionCab> findByCodigo (String codigo);
    List<ConfiguracionCab> findByConfigTipoId (Integer configTipoId);
}