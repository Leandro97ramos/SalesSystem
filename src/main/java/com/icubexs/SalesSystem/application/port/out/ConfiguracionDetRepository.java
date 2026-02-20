package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import java.util.List;
import java.util.Optional;

public interface ConfiguracionDetRepository {
    ConfiguracionDet save (ConfiguracionDet configuracionDet);
    void deleteById(Integer id);
    Optional<ConfiguracionDet> findById(Integer configuracionId);
    List<ConfiguracionDet> findByConfiguracionCabId (Integer configuracionCabId);
}