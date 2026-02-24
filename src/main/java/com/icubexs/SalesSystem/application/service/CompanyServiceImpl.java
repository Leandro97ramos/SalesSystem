package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.CompanyService;
import com.icubexs.SalesSystem.domain.model.Company;
import com.icubexs.SalesSystem.application.port.out.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    @Override
    public Company save(Company company) {
        return repository.save(company);
    }

    @Override
    public Optional<Company> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Company> findByTaxId(String taxId) {
        return repository.findByTaxId(taxId);
    }

    @Override
    public List<Company> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Company> findByParentId(Long parentId) {
        return repository.findByParentId(parentId);
    }
}