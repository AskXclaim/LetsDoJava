create table profiles
(
    id             bigint       not null
        primary key,
    user_id        bigint        not null,
    bio            nvarchar(255) null,
    phone_number   nvarchar(255) null,
    date_of_birth  nvarchar(255) null,
    loyalty_points nvarchar(255) null,
    constraint profiles_pk_2
        unique (user_id),
    constraint profiles_users_id_fk
        foreign key (user_id) references users (id)
);