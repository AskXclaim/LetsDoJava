create table IF NOT EXISTS store.tags
(
    id   bigint auto_increment primary key,
    name varchar(100) charset utf8mb4 not null
);

