package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.Company;
import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company save(Company company);
    Optional<Company> findById(Long id);
    Optional<Company> findByTaxId(String taxId);
    List<Company> findAll();
    List<Company> findByParentId(Long parentId);
}