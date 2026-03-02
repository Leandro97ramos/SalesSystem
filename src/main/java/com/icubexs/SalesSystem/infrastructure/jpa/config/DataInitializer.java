package com.icubexs.SalesSystem.infrastructure.jpa.config;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.*;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime; // También la necesitarás para fechas
@Configuration
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ConfiguracionTipoJpaRepository tipoRepo;
    private final ConfiguracionCabJpaRepository cabRepo;
    private final ConfiguracionDetJpaRepository detRepo;
    private final GeoLocationJpaRepository geoRepo;
    private final CompanyJpaRepository companyRepo;
    private final PersonJpaRepository personRepo;
    private final UserJpaRepository userRepo;
    private final WarehouseJpaRepository warehouseRepo;
    private final ProductJpaRepository productRepo;
    private final BatchJpaRepository batchRepo;
    private final StockJpaRepository stockRepo;

    @Override
    @Transactional
    public void run(String... args) {
        if (tipoRepo.count() == 0) {
            System.out.println("🌱 Iniciando carga maestra con nuevas reglas de formato...");

            // --- 1. CONFIGURACIÓN (MOTOR) ---
            // TIPO: SISTEMA
            ConfiguracionTipoEntity tipoSys = tipoRepo.save(ConfiguracionTipoEntity.builder()
                    .codigo("SIS-0000").nombre("SISTEMA").activo(true).build());

            // CABECERA: ROLES
            ConfiguracionCabEntity cabRoles = cabRepo.save(ConfiguracionCabEntity.builder()
                    .tipo(tipoSys).codigo("ROL-0000").nombre("ROLES_SISTEMA").activo(true).build());

            // DETALLES: ADMIN Y VENDEDOR
            ConfiguracionDetEntity detAdmin = detRepo.save(ConfiguracionDetEntity.builder()
                    .cabecera(cabRoles).codigo("ADM-0001").nombre("ROL_ADM").parametro("ADMINISTRADOR").activo(true).build());

            ConfiguracionDetEntity detVendRole = detRepo.save(ConfiguracionDetEntity.builder()
                    .cabecera(cabRoles).codigo("VEN-0001").nombre("ROL_VENDEDOR").parametro("VENDEDOR").activo(true).build());

            // CABECERA: TIPOS DE USUARIO (Comprador vs Vendedor)
            ConfiguracionCabEntity cabTipoUsr = cabRepo.save(ConfiguracionCabEntity.builder()
                    .tipo(tipoSys).codigo("USR-0000").nombre("TIPOS_USUARIO").activo(true).build());

            ConfiguracionDetEntity detComp = detRepo.save(ConfiguracionDetEntity.builder()
                    .cabecera(cabTipoUsr).codigo("COM-0001").nombre("TIPO_COMPRADOR").parametro("COMPRADOR").activo(true).build());

            // --- 2. LOCALIZACIÓN Y EMPRESAS ---
            GeoLocationEntity loc = geoRepo.save(GeoLocationEntity.builder()
                    .cityName("Olavarría").regionCountry("Argentina").postalCode("7400").build());

            CompanyEntity miEmpresa = companyRepo.save(CompanyEntity.builder()
                    .legalName("SalesSystem HQ").taxIdNumber("30-11112222-9").build());

            // --- 3. PERSONAS (Campos completos: phone, personal_address, identification) ---
            PersonEntity pLeandro = personRepo.save(PersonEntity.builder()
                    .firstName("Leandro")
                    .lastName("Ramos") // El apellido como identificador secundario
                    .identification("DNI-33444555")
                    .phone("2284-112233")
                    .personalAddress("Calle Rivadavia 1234")
                    .build());

            PersonEntity pRoberto = personRepo.save(PersonEntity.builder()
                    .firstName("Roberto")
                    .lastName("Comprador")
                    .identification("CUIT-30-555666-9")
                    .phone("2284-998877")
                    .personalAddress("Av. Pringles 456")
                    .build());

            // --- 4. USUARIOS (Regla Comprador con empresa / Vendedor sin empresa) ---
            userRepo.save(UserEntity.builder()
                    .username("leandro_admin").email("leandro@sales.com").passwordHash("secure_hash")
                    .person(pLeandro).company(null).build());

            userRepo.save(UserEntity.builder()
                    .username("roberto_comp").email("roberto@cliente.com").passwordHash("secure_hash")
                    .person(pRoberto).company(miEmpresa).build());

            // --- 5. LOGÍSTICA (Warehouse, Batch y Stock) ---
            WarehouseEntity wh = warehouseRepo.save(WarehouseEntity.builder()
                    .name("Depósito Olavarría").company(miEmpresa).geoLocation(loc).build());

            ProductEntity prod = productRepo.save(ProductEntity.builder()
                    .sku("PROD-0001").name("Monitor LED 24").basePrice(new BigDecimal("185000.00"))
                    .appliesTax(true).isSerialized(false).build());

            BatchEntity lote = batchRepo.save(BatchEntity.builder()
                    .product(prod).company(miEmpresa).code("LOT-2026-001")
                    .initialQuantity(50).currentQuantity(50)
                    .unitCost(new BigDecimal("120000.00")).entryDate(LocalDateTime.now()).build());

            // Ubicación del stock (vinculado a un detalle de configuración)
            stockRepo.save(StockEntity.builder()
                    .batch(lote).product(prod).currentQuantity(50).build());

            System.out.println("✅ Seeder actualizado con formatos y campos de persona corregidos.");
        }
    }
}