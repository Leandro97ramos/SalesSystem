package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.domain.model.Lote;
import com.icubexs.SalesSystem.domain.model.repository.LoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoteService {
    private final LoteRepository loteRepository;

    public Lote registrarLote(Lote lote) {
        // Aquí podrías validar que el ItemId exista antes de guardar
        return loteRepository.save(lote);
    }
}
