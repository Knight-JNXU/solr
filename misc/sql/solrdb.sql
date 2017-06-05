create database solrdb;

create sequence serial_id increment by 1 minvalue 1 no maxvalue start with 1;

create table t_item_category
(
	id int8 not null primary key default nextval('serial_id'),
	item_id int8,
	category_id int8
);
create table t_item
(
	id int8 not null primary key,
	name varchar(256)
);
create table t_category
(
	id int8 not null primary key,
	name varchar(256)
);

insert into t_item_category(item_id, category_id) values(1, 1);
insert into t_item_category(item_id, category_id) values(2, 1);
insert into t_item values(1, 'Reebok GL 6000 ND');
insert into t_item values(2, 'Reebok AZTEC RETRO ');
insert into t_category values(1, '鞋 ');