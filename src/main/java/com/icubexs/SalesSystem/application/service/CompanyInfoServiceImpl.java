package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.CompanyInfoService;
import com.icubexs.SalesSystem.application.port.out.CompanyInfoRepository;
import com.icubexs.SalesSystem.domain.model.CompanyInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyInfoServiceImpl implements CompanyInfoService {

    private final CompanyInfoRepository repository;

    @Override
    public CompanyInfo save(CompanyInfo companyInfo) {
        return repository.save(companyInfo);
    }

    @Override
    public Optional<CompanyInfo> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<CompanyInfo> findByCompanyId(Long companyId) {
        return repository.findByCompanyId(companyId);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}