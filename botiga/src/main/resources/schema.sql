
-- Crea la taula subcategoria
CREATE TABLE subcategoria (
    id_subcategoria BIGINT AUTO_INCREMENT PRIMARY KEY,
    desc_subcategoria VARCHAR(255) NOT NULL,
    status_subcategoria VARCHAR(100),
    categoria_id BIGINT,
    creation_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_categoria
        FOREIGN KEY (categoria_id)
        REFERENCES categoria(id_categoria)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);
