create table IF NOT EXISTS store.addresses
(
    id            bigint auto_increment primary key,
    street        varchar(200) charset utf8mb4 not null,
    city          varchar(100) charset utf8mb4 not null,
    post_zip_code varchar(20) charset utf8mb4  not null,
    user_id       bigint                       not null,
    constraint addresses_users_id_fk
        foreign key (user_id) references store.users (id)
);

