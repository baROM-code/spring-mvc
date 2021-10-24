CREATE TABLE products (
    id serial primary key,
    title text not null,
	description text,
    imagelink text,
    price int not null
);