package com.icubexs.SalesSystem.infraestructure.jpa.adapter.out.persistence;


@Component
@RequiredArgsConstructor
public class LotePersistenceAdapter implements LoteRepository {
    private final JpaLoteRepository jpaLoteRepository;

    @Override
    public Lote save(Lote lote) {
        LoteEntity entity = new LoteEntity();
        entity.setItemId(lote.getItemId());
        entity.setCodigoLote(lote.getCodigoLote());
        entity.setFechaIngreso(lote.getFechaIngreso());
        entity.setFechaVencimiento(lote.getFechaVencimiento());
        entity.setProveedorId(lote.getProveedorId());

        LoteEntity saved = jpaLoteRepository.save(entity);
        return new Lote(saved.getLoteId(), saved.getItemId(), saved.getCodigoLote(),
                saved.getFechaIngreso(), saved.getFechaVencimiento(), saved.getProveedorId());
    }
}
