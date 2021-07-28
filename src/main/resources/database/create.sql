create database cinema;

create table roles(
    role varchar(20) primary key
);

create table users(
    id serial primary key,
    name varchar(20) not null unique,
    password varchar(500) not null,
    id_role varchar(20) references roles(role)
);