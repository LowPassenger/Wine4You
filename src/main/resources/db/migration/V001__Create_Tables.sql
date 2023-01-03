alter table if exists orders
    drop constraint if exists FK32ql8ubntj5uh44ph9659tiih;

alter table if exists orders_wines
    drop constraint if exists FKfb3gfhxg6g4ydjr80y2foqrsa;

alter table if exists orders_wines
    drop constraint if exists FKlkjjmij0q9nurt1a1rrcm9yf5;

alter table if exists shopping_carts
    drop constraint if exists FKc1fbrvff059ke4p8ce3hu38oa;

alter table if exists shopping_carts_products
    drop constraint if exists FKlqquvf61c1r7bme4e558a0q9;

alter table if exists shopping_carts_products
    drop constraint if exists FK8ofq6ppk9gndq09rgw5ukp618;

alter table if exists users
    drop constraint if exists FKpit3woesw8x1062syim3kei69;

alter table if exists users_roles
    drop constraint if exists FKj6m8fwv7oqv74fcehir1a9ffy;

alter table if exists users_roles
    drop constraint if exists FK2o0jvgh89lemvvo17cbqvdxaa;

alter table if exists wine_images
    drop constraint if exists FKdpapwy563s2cf4td49ttyn3lg;

alter table if exists wines
    drop constraint if exists FK95ndewxh6j4t20rcoa2xcpwyy;

alter table if exists wines
    drop constraint if exists FK3x5ee3me3hblcpeeuofiss2py;

alter table if exists wines
    drop constraint if exists FKkhyec7v6xw334awt2ged8nf27;

drop table if exists events cascade;
drop table if exists orders cascade;
drop table if exists orders_wines cascade;
drop table if exists roles cascade;
drop table if exists shopping_carts cascade;
drop table if exists shopping_carts_products cascade;
drop table if exists styles cascade;
drop table if exists tastes cascade;
drop table if exists users cascade;
drop table if exists users_roles cascade;
drop table if exists wine_images cascade;
drop table if exists wines cascade;

create table events (
                        id  bigserial not null,
                        name_event varchar(255),
                        primary key (id)
);

create table orders (
                        id  bigserial not null,
                        order_time timestamp,
                        user_id int8,
                        primary key (id)
);

create table orders_wines (
                              order_id int8 not null,
                              wine_id int8 not null
);

create table roles (
                       id  bigserial not null,
                       role_name varchar(255),
                       primary key (id)
);

create table shopping_carts (
                                id int8 not null,
                                primary key (id)
);

create table shopping_carts_products (
                                         shopping_cart_id int8 not null,
                                         product_id int8 not null
);

create table styles (
                        id  bigserial not null,
                        name_style varchar(255),
                        primary key (id)
);

create table tastes (
                        id  bigserial not null,
                        name_taste varchar(255),
                        primary key (id)
);

create table users (
                       id  bigserial not null,
                       address varchar(255) not null,
                       birthday date not null,
                       city varchar(255) not null,
                       email varchar(255) not null,
                       first_name varchar(255) not null,
                       last_name varchar(255) not null,
                       password varchar(255) not null,
                       phone varchar(255) not null,
                       registration_date timestamp,
                       shopping_cart_id int8,
                       primary key (id)
);

create table users_roles (
                             user_id int8 not null,
                             role_id int8 not null,
                             primary key (user_id, role_id)
);

create table wine_images (
                             id  bigserial not null,
                             image bytea not null,
                             name varchar(255),
                             type varchar(255),
                             url_path varchar(255),
                             wine_id int8 not null,
                             primary key (id)
);

create table wines (
                       id  bigserial not null,
                       brand varchar(255),
                       made_in_country varchar(255),
                       in_stock boolean,
                       price numeric(19, 2),
                       title varchar(255),
                       capacity float8,
                       description varchar(255),
                       name varchar(255),
                       wine_type varchar(255),
                       event_id int8,
                       wine_style_id int8,
                       wine_taste_id int8,
                       primary key (id)
);

alter table if exists orders_wines
    add constraint UK_9e99ew6dhol8r1xkxd3k0hncp unique (wine_id);

alter table if exists roles
    add constraint UK_716hgxp60ym1lifrdgp67xt5k unique (role_name);

alter table if exists shopping_carts_products
    add constraint UK_9m3ymtfvxtxcb1ukw8lse9t5h unique (product_id);

alter table if exists users
    add constraint UK1drr8bhslhiv9m1s9inur8vff unique (phone, email);

alter table if exists orders
    add constraint FK32ql8ubntj5uh44ph9659tiih
        foreign key (user_id)
            references users;

alter table if exists orders_wines
    add constraint FKfb3gfhxg6g4ydjr80y2foqrsa
        foreign key (wine_id)
            references wines;

alter table if exists orders_wines
    add constraint FKlkjjmij0q9nurt1a1rrcm9yf5
        foreign key (order_id)
            references orders;

alter table if exists shopping_carts
    add constraint FKc1fbrvff059ke4p8ce3hu38oa
        foreign key (id)
            references users;

alter table if exists shopping_carts_products
    add constraint FKlqquvf61c1r7bme4e558a0q9
        foreign key (product_id)
            references orders;

alter table if exists shopping_carts_products
    add constraint FK8ofq6ppk9gndq09rgw5ukp618
        foreign key (shopping_cart_id)
            references shopping_carts;

alter table if exists users
    add constraint FKpit3woesw8x1062syim3kei69
        foreign key (shopping_cart_id)
            references shopping_carts;

alter table if exists users_roles
    add constraint FKj6m8fwv7oqv74fcehir1a9ffy
        foreign key (role_id)
            references roles;

alter table if exists users_roles
    add constraint FK2o0jvgh89lemvvo17cbqvdxaa
        foreign key (user_id)
            references users;

alter table if exists wine_images
    add constraint FKdpapwy563s2cf4td49ttyn3lg
        foreign key (wine_id)
            references wines;

alter table if exists wines
    add constraint FK95ndewxh6j4t20rcoa2xcpwyy
        foreign key (event_id)
            references events;

alter table if exists wines
    add constraint FK3x5ee3me3hblcpeeuofiss2py
        foreign key (wine_style_id)
            references styles;

alter table if exists wines
    add constraint FKkhyec7v6xw334awt2ged8nf27
        foreign key (wine_taste_id)
            references tastes;