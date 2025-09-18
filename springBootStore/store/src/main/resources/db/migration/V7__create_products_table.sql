create table products
(
    id          bigint auto_increment primary key,
    category_id tinyint        not null,
    name        nvarchar(255)  not null,
    price       decimal(10, 2) not null,
    constraint products_categories_id_fk
        foreign key (category_id) references categories (id)
            on delete restrict
);
