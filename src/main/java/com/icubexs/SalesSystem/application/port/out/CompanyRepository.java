package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.Company;
import java.util.Optional;

public interface CompanyRepository {
    Company save(Company company);
    Optional<Company> findById(Long id);
}