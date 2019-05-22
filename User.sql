use users
drop table user;
create table if not exists user(
id int auto_increment primary key,
name varchar(20),
username varchar(20) unique,
gender varchar(1),
phoneno varchar(10) unique,
password varchar(254) not null,
role int references role(id)
);
select * from user;
insert into user(name, username, gender, phoneno, password, role) values ('munish', 'munish1117', 'M', '7889879070','ABC@12def',2);
insert into user(name, username, gender, phoneno, password, role) values ('avinash', 'avinash1117', 'M', '7889879071','ABC@12def',0);
select * from role;
select * from user where username = 'munish117';

create table role(
id varchar(1) primary key,
name varchar(60)
);

create table user_roles(
user_id int,
role_id int
);
insert into user_roles(user_id, role_id) values(3,2);

insert into role(id, name) values (0,'ROLE_USER');
insert into role(id, name) values (1,'ROLE_PM');
insert into role(id, name) values (2,'ROLE_ADMIN');
