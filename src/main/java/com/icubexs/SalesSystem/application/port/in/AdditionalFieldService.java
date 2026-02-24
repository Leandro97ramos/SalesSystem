package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.AdditionalField;
import java.util.List;
import java.util.Optional;

public interface AdditionalFieldService {
    AdditionalField save(AdditionalField additionalField);
    Optional<AdditionalField> findById(Long id);
    List<AdditionalField> findAll();
    void deleteById(Long id);
}

