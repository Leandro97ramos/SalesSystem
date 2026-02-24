package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.TaxRuleService;
import com.icubexs.SalesSystem.application.port.out.TaxRuleRepository;
import com.icubexs.SalesSystem.domain.model.TaxRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaxRuleServiceImpl implements TaxRuleService {

    private final TaxRuleRepository repository;

    @Override
    public TaxRule save(TaxRule taxRule) {
        return repository.save(taxRule);
    }

    @Override
    public Optional<TaxRule> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<TaxRule> findAll() {
        return repository.findAll();
    }

    @Override
    public List<TaxRule> findByGeoLocationId(Long geoLocationId) {
        return repository.findByGeoLocationId(geoLocationId);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}