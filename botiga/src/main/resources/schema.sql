
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

CREATE TABLE products (
    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    company VARCHAR(255) NOT NULL,
    price FLOAT NOT NULL,
    units BIGINT NOT NULL,
    creation_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    category_id BIGINT NOT NULL,
    subcategory_id BIGINT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories(id_Categoria) ON DELETE CASCADE,
    FOREIGN KEY (subcategory_id) REFERENCES subcategories(id_Subcategoria) ON DELETE CASCADE
);
