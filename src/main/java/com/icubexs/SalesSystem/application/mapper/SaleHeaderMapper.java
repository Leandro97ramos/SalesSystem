package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.SaleHeaderRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.SaleHeaderResponseDTO;
import com.icubexs.SalesSystem.domain.model.Company;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.domain.model.SaleHeader;
import com.icubexs.SalesSystem.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class SaleHeaderMapper {
    public SaleHeader toDomain(SaleHeaderRequestDTO request) {
        if (request == null) return null;
        return SaleHeader.builder()
                .company(Company.builder().id(request.getCompanyId()).build())
                .seller(User.builder().id(request.getSellerId()).build())
                .buyer(User.builder().id(request.getBuyerId()).build())
                .status(ConfiguracionDet.builder().id(request.getStatusId()).build())
                .subtotal(request.getSubtotal())
                .totalTax(request.getTotalTax())
                .totalSale(request.getTotalSale())
                .build();
    }

    public SaleHeaderResponseDTO toResponse(SaleHeader domain) {
        if (domain == null) return null;
        return SaleHeaderResponseDTO.builder()
                .id(domain.getId())
                .saleDate(domain.getSaleDate())
                .subtotal(domain.getSubtotal())
                .totalTax(domain.getTotalTax())
                .totalSale(domain.getTotalSale())
                .companyName(domain.getCompany() != null ? domain.getCompany().getLegalName() : null)
                .sellerUsername(domain.getSeller() != null ? domain.getSeller().getUsername() : null)
                .buyerFullName(domain.getBuyer() != null && domain.getBuyer().getPerson() != null ?
                        domain.getBuyer().getPerson().getFirstName() + " " + domain.getBuyer().getPerson().getLastName() : null)
                .statusName(domain.getStatus() != null ? domain.getStatus().getNombre() : null)
                .build();
    }
}