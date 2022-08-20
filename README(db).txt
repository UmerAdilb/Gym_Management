create table login(
id int not null auto_increment primary key,
username varchar(255),
password varchar(20),
type varchar(255)
);

create table trainer(
id int not null auto_increment primary key,
name varchar(255),
gender varchar(255),
age int,
contact varchar(255),
address varchar(255)

);

create table member_groups(
id int not null auto_increment primary key,
name varchar(255),
timing varchar(255),
type varchar(255),
trainer_id int,
foreign key(trainer_id) references trainer(id)
on delete cascade

);


create table member(
id int not null auto_increment primary key,
name varchar(255),
gender varchar(255),
age int,
contact varchar(255),
address varchar(255),
status varchar(255),
group_id int,
foreign key(group_id) references member_groups(id)
on delete cascade
);

create table payment(
id int not null auto_increment primary key,
amount double,
amount_remaining double,
date date,
month varchar(255),
year varchar(255),
member_id int, 
foreign key(member_id) references member(id)
on delete cascade
);







