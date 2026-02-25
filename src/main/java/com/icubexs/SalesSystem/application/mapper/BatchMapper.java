package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.BatchRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.BatchResponseDTO;
import com.icubexs.SalesSystem.domain.model.Batch;
import com.icubexs.SalesSystem.domain.model.Company;
import com.icubexs.SalesSystem.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public class BatchMapper {

    public Batch toDomain(BatchRequestDTO request) {
        if (request == null) return null;
        return Batch.builder()
                .product(Product.builder().id(request.getProductId()).build())
                .company(Company.builder().id(request.getCompanyId()).build())
                .code(request.getCode())
                .invoiceNumber(request.getInvoiceNumber())
                .initialQuantity(request.getInitialQuantity())
                .currentQuantity(request.getCurrentQuantity())
                .entryDate(request.getEntryDate())
                .expirationDate(request.getExpirationDate())
                .unitCost(request.getUnitCost())
                .build();
    }

    public BatchResponseDTO toResponse(Batch domain) {
        if (domain == null) return null;
        return BatchResponseDTO.builder()
                .id(domain.getId())
                .productName(domain.getProduct() != null ? domain.getProduct().getName() : null)
                .companyName(domain.getCompany() != null ? domain.getCompany().getLegalName() : null)
                .code(domain.getCode())
                .invoiceNumber(domain.getInvoiceNumber())
                .initialQuantity(domain.getInitialQuantity())
                .currentQuantity(domain.getCurrentQuantity())
                .entryDate(domain.getEntryDate())
                .expirationDate(domain.getExpirationDate())
                .unitCost(domain.getUnitCost())
                .build();
    }
}