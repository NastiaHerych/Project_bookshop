drop database if exists bookshop;
create database bookshop;

use bookshop;

create table bookshop (
	id int not null primary key auto_increment,
	bookName varchar(250) not null,
	bookAuthor varchar(250) not null,
	bookPrice decimal(5,2) not null default 0.00,
	quantity int not null 
);

create table user (
	id int not null primary key auto_increment,
    first_name varchar(45) not null,
    last_name varchar(45) not null,
    age int not null,
    address varchar(120) not null,
	user_email varchar(50) not null unique
);
drop table user;
select * from user;

create table bucket (
	id int not null primary key auto_increment,
    user_id int not null,
    book_id int not null, 
    date date not null
);

