package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.AdditionalFieldService;
import com.icubexs.SalesSystem.application.port.out.AdditionalFieldRepository;
import com.icubexs.SalesSystem.domain.model.AdditionalField;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdditionalFieldServiceImpl implements AdditionalFieldService {

    private final AdditionalFieldRepository repository;

    @Override
    public AdditionalField save(AdditionalField additionalField) {
        return repository.save(additionalField);
    }

    @Override
    public Optional<AdditionalField> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AdditionalField> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}