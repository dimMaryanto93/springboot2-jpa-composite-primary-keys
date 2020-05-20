create table products
(
    code         character varying(64)  not null,
    version      character varying(64)  not null,
    name         character varying(100) not null,
    price        decimal                         default 0,
    stock        int                             default 0,
    created_date timestamp              not null default now(),
    created_by   character varying(100) not null,
    primary key (code, version)
);

insert into products (code, version, name, price, stock, created_by)
values ('macbook-pro-13-touchbar', 'mid-2017', 'Macbook pro 13" touchbar', 25000000, 1, 'migration'),
       ('macbook-pro-13-touchbar', 'early-2017', 'Macbook pro 13" touchbar', 24000000, 1, 'migration'),
       ('macbook-pro-13-touchbar', 'early-2020', 'Macbook pro 13" touchbar', 28000000, 1, 'migration');
