create table IF NOT EXISTS store.profiles
(
    id             bigint auto_increment        not null primary key,
    user_id        bigint                       not null,
    bio            varchar(255) charset utf8mb4 null,
    phone_number   varchar(15) charset utf8mb4  null,
    date_of_birth  date                         not null,
    loyalty_points int unsigned default '0'     null,
    constraint profiles_users_id_fk
        foreign key (user_id) references store.users (id)
);

