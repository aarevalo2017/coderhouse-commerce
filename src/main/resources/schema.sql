--create database commerce;

drop table order_line, orders, clients, products;

create table clients (
	id int not null auto_increment,
    dni varchar(255) not null,
    name varchar(255) not null,
    last_name varchar(255) not null,
    primary key (id)
);

create table products (
	id int not null auto_increment,
	sku varchar(50) not null,
	description varchar(255) not null,
	price int not null,
	stock int not null,
	primary key (id)
);

create table orders (
    id int not null auto_increment,
    date datetime NOT NULL,
    client_id int NOT null,
    primary key (id),
    constraint fk_client foreign key (client_id) references clients(id)
);

create table order_line (
	id int not null auto_increment,
	quantity int not null,
	unit_price int not null,
	total_price int not null,
	order_id int not null,
	product_id int not null,
	primary key (id),
	constraint fk_order foreign key (order_id) references orders(id),
	constraint fk_product foreign key (product_id) references products(id)
);