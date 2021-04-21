BEGIN;

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (id bigserial PRIMARY KEY, name VARCHAR (255));
INSERT INTO users (name) VALUES
('ivan'),
('Petr'),
('Alexander'),
('Donald');

DROP TABLE IF EXISTS cashback CASCADE;
CREATE TABLE cashback (id bigserial PRIMARY KEY, user_id bigint, cash bigint, FOREIGN KEY (user_id) REFERENCES users (id));
INSERT INTO cashback (user_id, cash) VALUES
(1, 15),
(2, 52),
(3, 40),
(4, 35);

DROP TABLE IF EXISTS promo CASCADE;
CREATE TABLE promo (id bigserial PRIMARY KEY, product_id bigint, promo bigint, FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO promo (product_id, promo) VALUES
(1, 5),
(2, 5),
(3, 15),
(4, 45);

DROP TABLE IF EXISTS comments CASCADE;
CREATE TABLE comments (id bigserial PRIMARY KEY, product_id bigint, user_id bigint, comment VARCHAR (255), FOREIGN KEY (product_id) REFERENCES products (id),
                       FOREIGN KEY (user_id) REFERENCES users (id));
INSERT INTO comments (product_id, user_id, comment) VALUES
(1, 1, 'The best'),
(2, 1, 'Middle'),
(3, 4, 'Good'),
(4, 3, '5 stars');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, name VARCHAR (255), cost bigint);
INSERT INTO products (name, cost) VALUES
('Apple', 15),
('Book', 52),
('Dress', 40),
('Pen', 35),
('Knife', 75);

DROP TABLE IF EXISTS categories CASCADE;
CREATE TABLE categories (id bigserial PRIMARY KEY, name VARCHAR (255));
INSERT INTO categories (name) VALUES
('Fruit'),
('Writing goods'),
('Clothes'),
('Home');

DROP TABLE IF EXISTS product_category CASCADE;
CREATE TABLE product_category (product_id bigint, category_id bigint, FOREIGN KEY (product_id) REFERENCES products (id),
                               FOREIGN KEY (category_id) REFERENCES categories (id));
INSERT INTO product_category (product_id, category_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 2),
(5, 5);

DROP TABLE IF EXISTS product_items CASCADE;
CREATE TABLE product_items (id bigserial PRIMARY KEY, product_id bigint, serial_number bigint, FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO product_items (product_id, serial_number) VALUES
(1, 5988),
(2, 99347),
(3, 64134),
(4, 794453),
(5, 157651);

DROP TABLE IF EXISTS storage CASCADE;
CREATE TABLE storage (id bigserial PRIMARY KEY, product_item_id bigint, amount bigint, FOREIGN KEY (product_item_id) REFERENCES product_items (id));
INSERT INTO storage (product_item_id, amount) VALUES
(1, 29),
(2, 45),
(3, 1),
(4, 108),
(5, 3);

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders (id bigserial PRIMARY KEY, product_item_id bigint, user_id bigint, order_sum bigint,
                                FOREIGN KEY (product_item_id) REFERENCES product_items (id),
                               FOREIGN KEY (user_id) REFERENCES users (id));
INSERT INTO orders (product_item_id, user_id) VALUES
(1, 1),
(2, 1),
(3, 3),
(4, 4),
(5, 4);

DROP TABLE IF EXISTS order_status CASCADE;
CREATE TABLE order_status(id bigserial PRIMARY KEY, order_id bigint, order_status VARCHAR (255), data VARCHAR (255),
                          FOREIGN KEY (order_id) REFERENCES orders (id));
INSERT INTO order_status (order_id, order_status, data) VALUES
(1, 'In the cart'),
(2, 'Paid', '22-03-2021'),
(3, 'Delivered', '25-03-2021'),
(4, 'Returned', '26-03-2021'),
(5, 'Paid', '04-04-2021');

COMMIT;



