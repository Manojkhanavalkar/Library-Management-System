--spring boot uses schema.sql for ddl commands

create table if not exists books(
    id serial primary key,
    title varchar(255) not null,
    about text,
    author varchar(255),
    language varchar(255),
    available BOOLEAN DEFAULT TRUE
);

create table if not exists users(
    user_id serial primary key,
    user_name text,
    user_phone_no int,
    user_address text,
    books_issued int,
    book_id int references books
);