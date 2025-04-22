CREATE DATABASE IF NOT EXISTS botiga;
USE botiga;

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

-- Inserts para la taula CATEGORIA
INSERT INTO categoria (desc_Categoria, status_Categoria) VALUES ('Electrónica', 'Activo');
INSERT INTO categoria (desc_Categoria, status_Categoria) VALUES ('Ropa', 'Activo');
INSERT INTO categoria (desc_Categoria, status_Categoria) VALUES ('Hogar', 'Inactivo');
INSERT INTO categoria (desc_Categoria, status_Categoria) VALUES ('Juguetes', 'Activo');
INSERT INTO categoria (desc_Categoria, status_Categoria) VALUES ('Deportes', 'Activo');

-- Inserts para la taula SUBCATEGORIA
INSERT INTO subcategoria (desc_Subcategoria, status_Subcategoria, categoria_id) VALUES ('Smartphones', 'Activo', 1);
INSERT INTO subcategoria (desc_Subcategoria, status_Subcategoria, categoria_id) VALUES ('Ordenadores', 'Activo', 1);
INSERT INTO subcategoria (desc_Subcategoria, status_Subcategoria, categoria_id) VALUES ('Zapatos', 'Activo', 2);
INSERT INTO subcategoria (desc_Subcategoria, status_Subcategoria, categoria_id) VALUES ('Muebles', 'Inactivo', 3);
INSERT INTO subcategoria (desc_Subcategoria, status_Subcategoria, categoria_id) VALUES ('Bicicletas', 'Activo', 5);

-- Inserts para la taula PRODUCTE
INSERT INTO producte (name, description, company, price, units, category_id, subcategory_id) 
VALUES ('iPhone 13', 'Smartphone Apple', 'Apple', 999.99, 50, 1, 1);

INSERT INTO producte (name, description, company, price, units, category_id, subcategory_id) 
VALUES ('Laptop Dell', 'Ordenador portátil Dell', 'Dell', 799.99, 30, 1, 2);

INSERT INTO producte (name, description, company, price, units, category_id, subcategory_id) 
VALUES ('Zapatos Nike', 'Zapatos deportivos Nike', 'Nike', 59.99, 100, 2, 3);

INSERT INTO producte (name, description, company, price, units, category_id, subcategory_id) 
VALUES ('Silla de oficina', 'Silla ergonómica de oficina', 'Ikea', 129.99, 40, 3, 4);

INSERT INTO producte (name, description, company, price, units, category_id, subcategory_id) 
VALUES ('Bicicleta de montaña', 'Bicicleta para montaña', 'Decathlon', 299.99, 20, 5, 5);
