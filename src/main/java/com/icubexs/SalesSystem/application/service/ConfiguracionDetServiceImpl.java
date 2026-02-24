package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.ConfiguracionDetService;
import com.icubexs.SalesSystem.application.port.out.ConfiguracionDetRepository;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConfiguracionDetServiceImpl implements ConfiguracionDetService {

    private final ConfiguracionDetRepository repository;

    @Override
    public ConfiguracionDet save(ConfiguracionDet detalle) {
        return repository.save(detalle);
    }

    @Override
    public Optional<ConfiguracionDet> findByCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }

    @Override
    public List<ConfiguracionDet> findByCabecera(String cabeceraCodigo) {
        return repository.findByCabeceraCodigo(cabeceraCodigo);
    }

    @Override
    public List<ConfiguracionDet> findChildren(Long padreId) {
        return repository.findChildrenByPadreId(padreId);
    }
}