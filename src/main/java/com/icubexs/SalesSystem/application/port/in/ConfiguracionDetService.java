package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import java.util.List;
import java.util.Optional;

public interface ConfiguracionDetService {
    ConfiguracionDet save(ConfiguracionDet detalle);
    Optional<ConfiguracionDet> findByCodigo(String codigo);
    List<ConfiguracionDet> findByCabecera(String cabeceraCodigo);
    List<ConfiguracionDet> findChildren(Long padreId);
}