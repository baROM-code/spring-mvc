CREATE TABLE products
(
    id          serial primary key,
    title       text not null,
    description text,
    imagelink   text,
    price       int  not null
);

CREATE TABLE goods
(
    id    serial primary key,
    title text not null,
    price int  not null
);

CREATE TABLE buyers
(
    id       serial primary key,
    name     text not null,
    goods_id int,
    foreign key (goods_id) references goods (id)
);

create table users
(
    id       bigserial,
    username varchar(30) not null unique,
    password varchar(80) not null,
    email    varchar(50) unique,
    enabled  boolean default true,
    primary key (id)
);

create table role
(
    id   serial,
    name varchar(50) not null,
    primary key (id)
);

CREATE TABLE user_role
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references role (id)
);

insert into role (name)
values ('ROLE_USER'),
       ('ROLE_MANAGER'),
       ('ROLE_ADMIN');

insert into users (username, password, email)
values ('admin', '$2a$10$FhjR1/4beuDWF07HSaoDC.aZAiUIotv64tAgRlEDtyP0pq1M/R4KG', 'admin@shop.com');

insert into user_role (user_id, role_id)
values (1, 2),
       (1, 3);