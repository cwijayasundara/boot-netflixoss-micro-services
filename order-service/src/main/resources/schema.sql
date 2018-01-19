
DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
  order_id        VARCHAR(100) PRIMARY KEY NOT NULL,
  product_id   TEXT NOT NULL,
  product_name      TEXT NOT NULL,
  customer_name      TEXT NOT NULL,
  customer_address       TEXT  NOT NULL,
  number_of_items INT,
  comment           VARCHAR(100));

INSERT INTO orders (order_id,  product_id, product_name, customer_name, customer_address, number_of_items,comment)
VALUES ('ord-1', 'prod-1', 'Thruster K9000','Chaminda W', '14 Wentworth Close',1,'badminton racket');
INSERT INTO orders (order_id,  product_id, product_name, customer_name, customer_address, number_of_items,comment)
VALUES ('ord-2', 'prod-2', 'Thruster K9900','Chamath W', '4 Elizabeth Court',2,'badminton racket');
INSERT INTO orders (order_id,  product_id, product_name, customer_name, customer_address, number_of_items,comment)
VALUES ('ord-3', 'prod-2', 'Thruster K9900','Chamudi W', '20 Wentworth Close',1,'tennis racket');
INSERT INTO orders (order_id,  product_id, product_name, customer_name, customer_address, number_of_items,comment)
VALUES ('ord-4', 'prod-1', 'Thruster K9000','Dinka P','8 Hampstead Road',1,'badminton racket');