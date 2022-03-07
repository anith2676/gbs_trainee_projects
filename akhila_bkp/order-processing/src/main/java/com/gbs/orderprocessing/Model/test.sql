create table orders (
    id integer not null,
    feedback varchar(255),
    net_price double,
    primary key (id)
) ;
create table product (
    id integer not null,
    product_category varchar(255),
    product_description varchar(255),
    product_image varchar(255),
    product_name varchar(255),
    product_price double,
    product_quantity integer,
    order_id integer,
    primary key (id)
) ;
create sequence hibernate_sequence start with 1 increment by 1
alter table
    product
add
    constraint FK18j7hot76crqfb6x6xn7mlxt6 foreign key (order_id) references orders