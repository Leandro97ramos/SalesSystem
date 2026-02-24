package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    Company save(Company company);
    Optional<Company> findById(Long id);
    // Agrega esta línea si falta:
    Optional<Company> findByTaxId(String taxId);
    List<Company> findAll();
    void deleteById(Long id);

    List<Company> findByParentId(Long parentId);
}