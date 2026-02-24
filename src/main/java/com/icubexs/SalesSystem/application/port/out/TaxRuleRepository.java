package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.TaxRule;
import java.util.List;
import java.util.Optional;

public interface TaxRuleRepository {
    TaxRule save(TaxRule taxRule);
    Optional<TaxRule> findById(Long id);
    List<TaxRule> findAll();
    List<TaxRule> findByGeoLocationId(Long geoLocationId);
    void deleteById(Long id);
}