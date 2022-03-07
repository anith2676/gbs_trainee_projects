create table products (
   id integer not null,
   product_category varchar(255),
   product_price double,
   product_description varchar(255),
   product_image varchar(255),
   product_name varchar(255),
   product_quantity integer,
   primary key (id)
);