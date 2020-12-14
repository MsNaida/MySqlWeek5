Create database if not exists orders;

use orders;
drop table if exists orders;

create table orders (
id int(10) not null auto_increment,
name varchar (20) not null,
flavor varchar (50) not null,
scoops int(5) not null,
primary key(id)
);