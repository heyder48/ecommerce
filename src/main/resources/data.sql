INSERT INTO CATEGORIA (NAME) VALUES ('INFORMATICA');
INSERT INTO CATEGORIA (NAME) VALUES ('ESCRITORIO');
INSERT INTO CATEGORIA (NAME) VALUES ('CAMA, MESA E BANHO');
INSERT INTO CATEGORIA (NAME) VALUES ('ELETRODOMESTICOS');
INSERT INTO CATEGORIA (NAME) VALUES ('LIVROS');

INSERT INTO PRODUCTS (name, description, price,categoria_id) VALUES ('Product 1', 'Description 1', 10.0,1);
INSERT INTO PRODUCTS (name, description, price,categoria_id) VALUES ('Product 2', 'Description 2', 20.0,2);
INSERT INTO PRODUCTS (name, description, price,categoria_id) VALUES ('Product 3', 'Description 3', 30.0,3);
INSERT INTO PRODUCTS (name, description, price,categoria_id) VALUES ('Product 4', 'Description 4', 40.0,4);
INSERT INTO PRODUCTS (name, description, price,categoria_id) VALUES ('Product 5', 'Description 5', 50.0,5);
INSERT INTO PRODUCTS (name, description, price,categoria_id) VALUES ('Product 6', 'Description 6', 60.0,1);
INSERT INTO PRODUCTS (name, description, price,categoria_id) VALUES ('Product 7', 'Description 7', 70.0,2);

INSERT INTO CUSTOMER (name, cpf, phone, email, address, password) VALUES ('Customer 1', '12345678901', '1234567890','teste@teste.com', 'Rua 5,chacara 5, Centro,Brasilia,df,72000000', '7c4a8d09ca3762af61e59520943dc26494f8941b');
