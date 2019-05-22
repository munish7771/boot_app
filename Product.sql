drop table product;
use users;
use products;
create table if not exists product(
id int auto_increment primary key,
name varchar(20),
category varchar(15),
description varchar(100)
);

insert into product(name, category, description) values ('mango','fruit','The king of fruits');
insert into product(name, category, description) values ('apple','fruit','The Queen of fruits');
insert into product(name, category, description) values ('lady finger','vegetable','Not a real finger');
insert into product(name, category, description) values ('tomato','fruit','ketchupp and salsa');

select * from product;