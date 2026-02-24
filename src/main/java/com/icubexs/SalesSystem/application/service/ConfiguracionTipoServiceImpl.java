package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.ConfiguracionTipoService;
import com.icubexs.SalesSystem.application.port.out.ConfiguracionTipoRepository;
import com.icubexs.SalesSystem.domain.model.ConfiguracionTipo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConfiguracionTipoServiceImpl implements ConfiguracionTipoService {

    private final ConfiguracionTipoRepository repository;

    @Override
    public ConfiguracionTipo create(ConfiguracionTipo tipo) {
        // Aquí podrías validar si el código ya existe antes de guardar
        return repository.save(tipo);
    }

    @Override
    public Optional<ConfiguracionTipo> findByCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }

    @Override
    public List<ConfiguracionTipo> findAllActive() {
        return repository.findAllActive();
    }
}