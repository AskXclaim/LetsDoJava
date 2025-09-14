create table IF NOT EXISTS store.users
(
    id       bigint auto_increment primary key,
    name     varchar(200) charset utf8mb4 not null,
    email    varchar(200) charset utf8mb4 not null,
    password varchar(200) charset utf8mb4 not null
);

