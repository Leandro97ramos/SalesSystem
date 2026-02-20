package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.service.CompanyService;
import com.icubexs.SalesSystem.domain.model.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> register(@RequestBody Company company) {
        // Llama al servicio de aplicación para procesar el registro
        return ResponseEntity.ok(companyService.registerCompany(company));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable Long id) {
        return companyService.findById(id) // Asumiendo que agregaste este método al service
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}