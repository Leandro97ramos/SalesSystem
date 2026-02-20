package com.icubexs.SalesSystem.infraestructure.jpa.adapter.in.rest;

@RestController
@RequestMapping("/api/v1/lotes")
@RequiredArgsConstructor
public class LoteController {
    private final LoteService loteService;

    @PostMapping
    public ResponseEntity<Lote> crear(@RequestBody Lote lote) {
        return ResponseEntity.ok(loteService.registrarLote(lote));
    }
}