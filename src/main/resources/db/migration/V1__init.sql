DROP TABLE IF EXISTS cashback CASCADE;
CREATE TABLE cashback (id bigserial PRIMARY KEY, cash bigint);
INSERT INTO cashback (cash) VALUES
(15),
(52),
(40),
(35);

DROP TABLE IF EXISTS roles CASCADE;
CREATE TABLE roles (id bigserial PRIMARY KEY, user_role VARCHAR (255));
INSERT INTO roles (user_role) VALUES
('user'),
('admin'),
('moderator');

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (id bigserial PRIMARY KEY, login VARCHAR (255), password VARCHAR (255), cash_id bigint, role_id bigint,
FOREIGN KEY (cash_id ) REFERENCES cashback (id), FOREIGN KEY (role_id) REFERENCES roles (id));
INSERT INTO users (login,password,cash_id,role_id) VALUES
('Ivan', 'i1', 1, 1),
('Petr', 'p1', 2, 1),
('Alexander', 'a1', 3, 2),
('Donald', 'd1', 4, 3);

DROP TABLE IF EXISTS promo CASCADE;
CREATE TABLE promo (id bigserial PRIMARY KEY, promo bigint);
INSERT INTO promo (promo) VALUES
(5),
(10),
(15),
(45);

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, name VARCHAR (255), price bigint, promo_id bigint,
 FOREIGN KEY (promo_id) REFERENCES promo (id));
INSERT INTO products (name, price, promo_id) VALUES
('Apple', 15, 1),
('Book', 52, 2),
('Dress', 40, 3),
('Pen', 35, 4),
('Knife', 75, 1);

DROP TABLE IF EXISTS categories CASCADE;
CREATE TABLE categories (id bigserial PRIMARY KEY, name VARCHAR (255));
INSERT INTO categories (name) VALUES
('Fruit'),
('Writing goods'),
('Clothes'),
('Home');

DROP TABLE IF EXISTS comments CASCADE;
CREATE TABLE comments (id bigserial PRIMARY KEY, product_id bigint, user_id bigint, comment VARCHAR (255), FOREIGN KEY (product_id) REFERENCES products (id),
                       FOREIGN KEY (user_id) REFERENCES users (id));
INSERT INTO comments (product_id, user_id, comment) VALUES
(1, 1, 'The best'),
(2, 1, 'Middle'),
(3, 4, 'Good'),
(4, 3, '5 stars');

DROP TABLE IF EXISTS product_category CASCADE;
CREATE TABLE product_category (product_id bigint, category_id bigint, FOREIGN KEY (product_id) REFERENCES products (id),
                               FOREIGN KEY (category_id) REFERENCES categories (id));
INSERT INTO product_category (product_id, category_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 2),
(5, 4);

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders (id bigserial PRIMARY KEY, user_id bigint, price bigint, create_date timestamp default current_timestamp,
                     FOREIGN KEY (user_id) REFERENCES users (id));
INSERT INTO orders (user_id) VALUES
(1),
(2),
(3),
(4),
(1);

DROP TABLE IF EXISTS order_status CASCADE;
CREATE TABLE order_status(id bigserial PRIMARY KEY, order_id bigint, order_status VARCHAR (255), create_date timestamp default current_timestamp,
                          FOREIGN KEY (order_id) REFERENCES orders (id));
INSERT INTO order_status (order_id, order_status) VALUES
(1, 'In the cart'),
(2, 'Paid'),
(3, 'Delivered'),
(4, 'Returned'),
(5, 'Paid');

DROP TABLE IF EXISTS product_items CASCADE;
CREATE TABLE product_items (id bigserial PRIMARY KEY, product_id bigint, order_id bigint, price bigint,
 FOREIGN KEY (product_id) REFERENCES products (id),FOREIGN KEY (order_id) REFERENCES orders (id) );
INSERT INTO product_items (product_id, order_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

DROP TABLE IF EXISTS storage CASCADE;
CREATE TABLE storage (id bigserial PRIMARY KEY, product_id bigint, amount bigint, FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO storage (product_id, amount) VALUES
(1, 29),
(2, 45),
(3, 1),
(4, 108),
(5, 3);








