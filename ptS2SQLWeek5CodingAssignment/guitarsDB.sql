create database if not exists guitars;

use guitars;

drop table if exists guitars;

create table guitars (
	id int(10) not null auto_increment,
	make varchar(50) not null,
	model varchar(50) not null,
	primary key(id)
);
	