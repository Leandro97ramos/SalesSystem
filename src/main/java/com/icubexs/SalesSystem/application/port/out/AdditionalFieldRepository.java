package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.AdditionalField;
import java.util.List;
import java.util.Optional;

public interface AdditionalFieldRepository {
    AdditionalField save(AdditionalField additionalField);
    Optional<AdditionalField> findById(Long id);
    List<AdditionalField> findAll();
    void deleteById(Long id);
}