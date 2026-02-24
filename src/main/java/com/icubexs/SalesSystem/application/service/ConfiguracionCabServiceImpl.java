package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.ConfiguracionCabService;
import com.icubexs.SalesSystem.application.port.out.ConfiguracionCabRepository;
import com.icubexs.SalesSystem.domain.model.ConfiguracionCab;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConfiguracionCabServiceImpl implements ConfiguracionCabService {

    private final ConfiguracionCabRepository repository;

    @Override
    public ConfiguracionCab save(ConfiguracionCab cabecera) {
        return repository.save(cabecera);
    }

    @Override
    public Optional<ConfiguracionCab> findByCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }

    @Override
    public List<ConfiguracionCab> findByTipo(Long tipoId) {
        return repository.findByTipoId(tipoId);
    }
}