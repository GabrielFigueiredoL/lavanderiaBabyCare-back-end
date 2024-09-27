CREATE TABLE product(
	id VARCHAR(128) PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	price INT NOT NULL,
	updated_at TIMESTAMP
);

CREATE TABLE orders(
	id VARCHAR(128) PRIMARY KEY,
	client_name VARCHAR(255) NOT NULL,
    client_phone VARCHAR(11) NOT NULL,
    pickup_date DATE NOT NULL,
    delivery_date DATE NOT NULL,
    cep VARCHAR(8),
    address VARCHAR(255) NOT NULL,
    district VARCHAR(255) NOT NULL,
    number VARCHAR(10) NOT NULL,
    complement VARCHAR(255),
    shipping INT NOT NULL,
    discount INT,
    status INT
);

CREATE TABLE order_status(
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE order_item(
    price INT NOT NULL,
    amount INT NOT NULL,
    product_id VARCHAR(128),
    order_id VARCHAR(128)
);

CREATE TABLE category(
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(128) NOT NULL
);

CREATE TABLE expense(
    id VARCHAR(128) PRIMARY KEY NOT NULL,
    description VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    price INTEGER NOT NULL
);

INSERT INTO product VALUES ("de8f0a73-85a7-5237-a279-fdd8a5412c25", "berço portátil", "3000", NOW());
INSERT INTO product VALUES ("08b4dc07-ea34-5590-8117-2df110e83968", "cadeirinha de alimentação p", "5000", NOW());
INSERT INTO product VALUES ("5157f9b8-16af-5b5e-a051-7436d18e0659", "cadeirinha de carro", "7000", NOW());
INSERT INTO product VALUES ("48131c05-0d29-5ee8-9156-854d7d86cace", "cadeirinha de descanso", "5000", NOW());
INSERT INTO product VALUES ("b137239c-3601-5a93-bc46-1a0a0b6884d1", "carrinho de gêmeo", "12000", NOW());
INSERT INTO product VALUES ("275cbfb4-a9b9-518b-930b-d62239571ec3", "carrinho tradicional", "7500", NOW());
INSERT INTO product VALUES ("4759cfa2-5387-55a3-93bd-7f4faca73101", "moisés", "6000", NOW());
INSERT INTO product VALUES ("87acfffc-7974-513e-b6d6-6464ad6e762c", "colchão de berço padrão", "3000", NOW());
INSERT INTO product VALUES ("a07f7219-4d3c-517a-b637-4bb66f70c92e", "ninho", "5000", NOW());
INSERT INTO product VALUES ("c4e073e7-8edd-5e07-bf65-816f61b869c2", "tapete de atividades", "4000", NOW());

INSERT INTO order_status VALUES(0, "toBeWithdrawn");
INSERT INTO order_status VALUES(1, "withdrawn");
INSERT INTO order_status VALUES(2, "processing");
INSERT INTO order_status VALUES(3, "toBeDelivery");
INSERT INTO order_status VALUES(4, "delivered");
INSERT INTO order_status VALUES(5, "toBePaid");
INSERT INTO order_status VALUES(6, "paid");

INSERT INTO category VALUES(0, "funcionários");
INSERT INTO category VALUES(1, "gasolina");
INSERT INTO category VALUES(2, "manutenção de equipamentos eletrônicos");
INSERT INTO category VALUES(3, "manutenção do carro");
INSERT INTO category VALUES(4, "manutenção do maquinário");
INSERT INTO category VALUES(5, "materiais");