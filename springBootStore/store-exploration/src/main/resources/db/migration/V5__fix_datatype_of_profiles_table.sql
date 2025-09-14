alter table profiles
    modify phone_number varchar(15) charset utf8mb3 null;

alter table profiles
    modify date_of_birth date not null;

alter table profiles
    modify loyalty_points int UNSIGNED default  0 null;