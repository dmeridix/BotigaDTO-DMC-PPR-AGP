-- Taula CATEGORIA
CREATE TABLE categoria (
    id_Categoria BIGINT AUTO_INCREMENT PRIMARY KEY,
    desc_Categoria VARCHAR(255) NOT NULL,
    status_Categoria VARCHAR(100),
    creation_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Taula SUBCATEGORIA
CREATE TABLE subcategoria (
    id_Subcategoria BIGINT AUTO_INCREMENT PRIMARY KEY,
    desc_Subcategoria VARCHAR(255) NOT NULL,
    status_Subcategoria VARCHAR(100),
    categoria_id BIGINT,
    creation_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_categoria
        FOREIGN KEY (categoria_id)
        REFERENCES categoria(id_Categoria)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- Taula PRODUCTE
CREATE TABLE producte (
    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    company VARCHAR(255) NOT NULL,
    price FLOAT NOT NULL,
    units BIGINT NOT NULL,
    creation_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    category_id BIGINT NOT NULL,
    subcategory_id BIGINT NOT NULL,
    FOREIGN KEY (category_id)
        REFERENCES categoria(id_Categoria)
        ON DELETE CASCADE,
    FOREIGN KEY (subcategory_id)
        REFERENCES subcategoria(id_Subcategoria)
        ON DELETE CASCADE
);