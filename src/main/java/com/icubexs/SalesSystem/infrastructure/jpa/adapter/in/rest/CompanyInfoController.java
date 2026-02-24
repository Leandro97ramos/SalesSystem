package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.CompanyInfoService;
import com.icubexs.SalesSystem.domain.model.CompanyInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company-info")
@RequiredArgsConstructor
public class CompanyInfoController {
    private final CompanyInfoService service;

    @PostMapping
    public ResponseEntity<CompanyInfo> save(@RequestBody CompanyInfo info) {
        return ResponseEntity.ok(service.save(info));
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<CompanyInfo>> findByCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(service.findByCompanyId(companyId));
    }
}
