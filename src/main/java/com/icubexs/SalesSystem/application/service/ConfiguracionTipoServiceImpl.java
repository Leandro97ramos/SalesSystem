package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.ConfiguracionTipoService;
import com.icubexs.SalesSystem.application.port.out.ConfiguracionTipoRepository;
import com.icubexs.SalesSystem.domain.model.ConfiguracionTipo;
import java.util.List;

@org.springframework.stereotype.Service
@lombok.RequiredArgsConstructor
class ConfiguracionTipoServiceImpl implements ConfiguracionTipoService {
    private final ConfiguracionTipoRepository repository;

    @Override
    public ConfiguracionTipo create(ConfiguracionTipo request) {
        return repository.save(request);
    }

    @Override
    public List<ConfiguracionTipo> getAll() {
        return repository.findAll();
    }

    @Override
    public ConfiguracionTipo getById(Integer configTipoId) {
        return repository.findById(configTipoId)
                .orElseThrow(() -> new RuntimeException("No se encuentra Tipo con id: " + configTipoId));
    }

    @Override
    public String getNuevoCodigo(String inicial) {
        List<ConfiguracionTipo> lstIniciales = repository.findByIniCodigo(inicial);
        if (lstIniciales.isEmpty()) return inicial + "-0000";

        java.util.Set<String> codigosExistentes = lstIniciales.stream()
                .map(ConfiguracionTipo::getCodigo)
                .collect(java.util.stream.Collectors.toSet());

        int contador = 0;
        String nuevoCodigo;
        do {
            nuevoCodigo = inicial + "-" + String.format("%04d", contador++);
        } while (codigosExistentes.contains(nuevoCodigo));

        return nuevoCodigo;
    }
}