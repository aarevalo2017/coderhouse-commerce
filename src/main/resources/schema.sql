create database IF NOT EXISTS commerce;

drop table if exists order_line, orders, clients, products;

create table clients (
  id bigint not null auto_increment, 
  dni varchar(255), 
  last_name varchar(255), 
  name varchar(255), 
  primary key (id)
) engine = InnoDB;

create table orders (
  id bigint not null auto_increment, 
  date datetime(6), 
  client_id bigint, 
  primary key (id),
  constraint fk_client foreign key (client_id) references clients (id)
) engine = InnoDB;

create table products (
  id bigint not null auto_increment, 
  description varchar(255), 
  price integer, 
  sku varchar(255), 
  stock integer, 
  primary key (id)
) engine = InnoDB;

create table order_line (
  id bigint not null auto_increment, 
  quantity integer, 
  total_price integer, 
  unit_price integer, 
  order_id bigint, 
  product_id bigint, 
  product_description varchar(255),
  primary key (id),
  constraint fk_order foreign key (order_id) references orders (id)
) engine = InnoDB;
