package com.icubexs.SalesSystem.application.port.out;
import com.icubexs.SalesSystem.domain.model.CompanyInfo;
import java.util.List;
import java.util.Optional;

public interface CompanyInfoRepository {
    CompanyInfo save(CompanyInfo companyInfo);
    Optional<CompanyInfo> findById(Long id);
    List<CompanyInfo> findByCompanyId(Long companyId);
    void deleteById(Long id);
}