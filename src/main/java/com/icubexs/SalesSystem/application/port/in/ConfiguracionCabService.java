package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.ConfiguracionCab;
import java.util.List;
import java.util.Optional;

public interface ConfiguracionCabService {
    ConfiguracionCab save(ConfiguracionCab cabecera);
    Optional<ConfiguracionCab> findByCodigo(String codigo);
    List<ConfiguracionCab> findByTipo(Long tipoId);
}

