-- ==========================================================
-- LIMPIEZA TOTAL
-- ==========================================================
DROP TABLE IF EXISTS sale_detail_stock CASCADE;
DROP TABLE IF EXISTS sale_detail CASCADE;
DROP TABLE IF EXISTS sale_payment CASCADE;
DROP TABLE IF EXISTS sale_header CASCADE;
DROP TABLE IF EXISTS tax_rule CASCADE;
DROP TABLE IF EXISTS offer_product CASCADE;
DROP TABLE IF EXISTS offer CASCADE;
DROP TABLE IF EXISTS inventory_transfer_detail CASCADE;
DROP TABLE IF EXISTS inventory_transfer CASCADE;
DROP TABLE IF EXISTS item CASCADE;
DROP TABLE IF EXISTS stock CASCADE;
DROP TABLE IF EXISTS batch_info CASCADE;
DROP TABLE IF EXISTS batch CASCADE;
DROP TABLE IF EXISTS warehouse CASCADE;
DROP TABLE IF EXISTS product_info CASCADE;
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS additional_field CASCADE;
DROP TABLE IF EXISTS user_permission CASCADE;
DROP TABLE IF EXISTS user_role CASCADE;
DROP TABLE IF EXISTS app_user CASCADE;
DROP TABLE IF EXISTS company_info CASCADE;
DROP TABLE IF EXISTS company CASCADE;
DROP TABLE IF EXISTS person CASCADE;
DROP TABLE IF EXISTS geo_location CASCADE;
DROP TABLE IF EXISTS configuracion_det CASCADE;
DROP TABLE IF EXISTS configuracion_cab CASCADE;
DROP TABLE IF EXISTS configuracion_tipo CASCADE;





-- ==========================================================
-- 1. ESQUEMA DE CONFIGURACIÓN (BASE DEL SISTEMA)
-- ==========================================================

CREATE TABLE configuracion_tipo (
    configuracion_tipo_id BIGSERIAL PRIMARY KEY,
    codigo VARCHAR(100) UNIQUE,
    nombre VARCHAR(100),
    estado VARCHAR(50),
    activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE configuracion_cab (
    configuracion_cab_id BIGSERIAL PRIMARY KEY,
    configuracion_tipo_id BIGINT REFERENCES configuracion_tipo(configuracion_tipo_id),
    codigo VARCHAR(100) UNIQUE,
    nombre VARCHAR(100),
    parametro VARCHAR(1000),
    estado VARCHAR(50),
    activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE configuracion_det (
    configuracion_det_id BIGSERIAL PRIMARY KEY,
    padre_configuracion_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id),
    configuracion_cab_id BIGINT REFERENCES configuracion_cab(configuracion_cab_id),
    codigo VARCHAR(100) UNIQUE,
    nombre VARCHAR(100),
    parametro VARCHAR(5000),
    estado VARCHAR(50),
    activo BOOLEAN DEFAULT TRUE
);


-- ==========================================================
-- 2. LOCALIZACIÓN Y EMPRESA
-- ==========================================================

CREATE TABLE geo_location (
    id BIGSERIAL PRIMARY KEY,
    city_name VARCHAR(100),
    region_country VARCHAR(100) NOT NULL,
    postal_code VARCHAR(20)
);

CREATE TABLE person (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    identification VARCHAR(50) UNIQUE NOT NULL,
    phone VARCHAR(20),
    personal_address TEXT
);

CREATE TABLE company (
    id BIGSERIAL PRIMARY KEY,
    tax_id_number VARCHAR(50) UNIQUE NOT NULL,
    legal_name VARCHAR(200) NOT NULL,
    parent_company_id BIGINT REFERENCES company(id),
    parent_configuration_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id)
);

--Company info

CREATE TABLE company_info (
    id BIGSERIAL PRIMARY KEY,
    additional_field_id BIGINT REFERENCES additional_field(id),
    entity_id BIGINT, -- ID de la empresa
    value TEXT
);

drop table company_info

-- ==========================================================
-- 3. USUARIOS Y SEGURIDAD
-- ==========================================================

CREATE TABLE app_user ( -- 'user' es palabra reservada en SQL
    id BIGSERIAL PRIMARY KEY,
    person_id BIGINT REFERENCES person(id),
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    company_id BIGINT REFERENCES company(id)
);

CREATE TABLE user_role (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES app_user(id),
    role_config_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id),
    status BOOLEAN DEFAULT TRUE
);

CREATE TABLE user_permission (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES app_user(id),
    permission_config_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id),
    permission_level VARCHAR(50) -- Ej: 'LECTURA', 'ESCRITURA', 'TOTAL'
);

-- ==========================================================
-- 4. CATÁLOGO DE PRODUCTOS
-- ==========================================================

-- Campos adicionales dinámicos
CREATE TABLE additional_field (
    id BIGSERIAL PRIMARY KEY,
    datasource_config_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id),
    data_type_config_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id),
    name VARCHAR(100) NOT NULL,
    description TEXT,
    attribute JSONB
);

CREATE TABLE product (
    id BIGSERIAL PRIMARY KEY,
    sku VARCHAR(100) UNIQUE NOT NULL,
    code VARCHAR(100),
    name VARCHAR(200) NOT NULL,
    description TEXT,
    is_serialized BOOLEAN DEFAULT FALSE,
    applies_tax BOOLEAN DEFAULT TRUE, -- <--- Nuevo atributo
    length DECIMAL(10,2),
    width DECIMAL(10,2),
    height DECIMAL(10,2),
    unit_measure_config_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id),
    measure_value DECIMAL(10,2),
    tax_category_config_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id), -- Categoría Fiscal //Electrodomestico, Ropa, comestible,etc.
    base_price DECIMAL(18,2) NOT NULL
);



CREATE TABLE product_info (
    id BIGSERIAL PRIMARY KEY,
    additional_field_id BIGINT REFERENCES additional_field(id),
    entity_id BIGINT, -- ID del Producto, Batch, etc.
    value TEXT
);

-- ==========================================================
-- 5. DEPÓSITO E INVENTARIO
-- ==========================================================

CREATE TABLE warehouse (
    id BIGSERIAL PRIMARY KEY,
    company_id BIGINT REFERENCES company(id),
    geo_location_id BIGINT REFERENCES geo_location(id),
    parent_warehouse_id BIGINT REFERENCES warehouse(id),
    parent_configuration_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id), -- Ej: "Principal", "Secundario"
    name VARCHAR(100) NOT NULL,
    address TEXT
);

CREATE TABLE batch (
    id BIGSERIAL PRIMARY KEY,
    product_id BIGINT REFERENCES product(id),
    company_id BIGINT REFERENCES company(id),
    code VARCHAR(100) NOT NULL,
    invoice_number VARCHAR(100),
    initial_quantity INT NOT NULL,
    current_quantity INT NOT NULL,
    entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    expiration_date TIMESTAMP,
    unit_cost DECIMAL(18,2)
);

-- Batch info

CREATE TABLE batch_info (
    id BIGSERIAL PRIMARY KEY,
    additional_field_id BIGINT REFERENCES additional_field(id),
    entity_id BIGINT REFERENCES batch(id),
    value TEXT
);

CREATE TABLE stock (
    id BIGSERIAL PRIMARY KEY,
    batch_id BIGINT REFERENCES batch(id),
    product_id BIGINT REFERENCES product(id),
    location_config_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id),
    current_quantity INT NOT NULL
);

CREATE TABLE item ( -- Para trazabilidad por Número de Serie
    id BIGSERIAL PRIMARY KEY,
    product_id BIGINT REFERENCES product(id),
    serial_number VARCHAR(100) UNIQUE,
    batch_id BIGINT REFERENCES batch(id),
    status_config_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id)
);


-- ==========================================================
-- 6. MÓDULO DE LOGÍSTICA (TRASLADOS)
-- ==========================================================



CREATE TABLE inventory_transfer (
    id BIGSERIAL PRIMARY KEY,
    source_warehouse_id BIGINT REFERENCES warehouse(id),
    destination_warehouse_id BIGINT REFERENCES warehouse(id),
    user_id BIGINT REFERENCES app_user(id),
    transfer_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status_config_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id),
    description TEXT -- Notas del traslado
);

CREATE TABLE inventory_transfer_detail (
    id BIGSERIAL PRIMARY KEY,
    inventory_transfer_id BIGINT REFERENCES inventory_transfer(id),
    batch_id BIGINT REFERENCES batch(id),
    quantity DECIMAL(18,2) NOT NULL
);





-- ==========================================================
-- 7. MÓDULO DE OFERTAS Y PRECIOS
-- ==========================================================

CREATE TABLE offer (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    discount_type_config_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id),
    discount_value DECIMAL(18,2) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE offer_product (
    id BIGSERIAL PRIMARY KEY,
    offer_id BIGINT REFERENCES offer(id) ON DELETE CASCADE,
    product_id BIGINT REFERENCES product(id) ON DELETE CASCADE
);

CREATE TABLE tax_rule (
    id BIGSERIAL PRIMARY KEY,
    geo_location_id BIGINT REFERENCES geo_location(id),
    tax_category_config_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id), -- Ej: "Electrodomésticos"
    tax_value_config_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id)     -- Ej: "15%"
);

-- ==========================================================
-- 8. MÓDULO DE VENTAS Y FACTURACIÓN
-- ==========================================================

CREATE TABLE sale_header (
    id BIGSERIAL PRIMARY KEY,
    company_id BIGINT REFERENCES company(id),
    seller_user_id BIGINT REFERENCES app_user(id),
    buyer_user_id BIGINT REFERENCES app_user(id),
    sale_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status_config_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id),
    subtotal DECIMAL(18,2) NOT NULL,
    total_tax DECIMAL(18,2) NOT NULL,
    total_sale DECIMAL(18,2) NOT NULL
);

CREATE TABLE sale_payment (
    id BIGSERIAL PRIMARY KEY,
    sale_id BIGINT REFERENCES sale_header(id),
    payment_method_config_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id),
    amount_paid DECIMAL(18,2) NOT NULL,
    transaction_reference VARCHAR(255)
);

CREATE TABLE sale_detail (
    id BIGSERIAL PRIMARY KEY,
    sale_id BIGINT REFERENCES sale_header(id),
    product_id BIGINT REFERENCES product(id),
    offer_id BIGINT REFERENCES offer(id), -- Conexión con Ofertas
    quantity DECIMAL(18,2) NOT NULL,
    unit_price DECIMAL(18,2) NOT NULL,
    tax_rate_config_det_id BIGINT REFERENCES configuracion_det(configuracion_det_id), -- ID del impuesto aplicado
    applied_tax_rate DECIMAL(5,2),                        -- Snapshot del % (ej. 15.00)
    tax_amount DECIMAL(18,2),                             -- Monto de impuesto calculado (ej. 15% de unit_price * quantity)
    discount_amount DECIMAL(18,2) DEFAULT 0,
    total DECIMAL(18,2) NOT NULL                  -- Total con impuesto incluido
);

-- Trazabilidad física de la venta (Lotes y Series)
CREATE TABLE sale_detail_stock (
    id BIGSERIAL PRIMARY KEY,
    sale_detail_id BIGINT REFERENCES sale_detail(id),
    stock_id BIGINT REFERENCES stock(id),
    item_id BIGINT REFERENCES item(id), -- Solo si el producto es seriado
    quantity DECIMAL(18,2) NOT NULL
);
