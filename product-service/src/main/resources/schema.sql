
DROP TABLE IF EXISTS products;

CREATE TABLE products (
  product_id        VARCHAR(100) PRIMARY KEY NOT NULL,
  product_name                   TEXT NOT NULL,
  unit_price           TEXT NOT NULL,
  manufacturer          TEXT NOT NULL,
  meterial          TEXT   NOT NULL);

INSERT INTO products (product_id, product_name, unit_price, manufacturer, meterial)
VALUES ('prod-1', 'Thruster K9000', '150', 'Victor', 'carbon');
INSERT INTO products (product_id, product_name, unit_price, manufacturer, meterial)
VALUES ('prod-2', 'Thruster K9900', '140','Victor', 'carbon');