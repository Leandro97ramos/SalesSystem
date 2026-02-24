package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import java.util.List;
import java.util.Optional;

public interface ConfiguracionDetRepository {
    ConfiguracionDet save(ConfiguracionDet detalle);
    Optional<ConfiguracionDet> findById(Long id);
    Optional<ConfiguracionDet> findByCodigo(String codigo);

    // Búsqueda por cabecera para facilitar la obtención de listas (ej. estados)
    List<ConfiguracionDet> findByCabeceraCodigo(String cabeceraCodigo);

    // Para manejar la relación recursiva padre_configuracion_det_id
    List<ConfiguracionDet> findChildrenByPadreId(Long padreId);

}