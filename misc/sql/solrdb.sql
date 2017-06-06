/*建表插入数据*/

create sequence item_category_serial_id increment by 1 minvalue 1 no maxvalue start with 1;
create sequence item_serial_id increment by 1 minvalue 1 no maxvalue start with 1;
create sequence category_serial_id increment by 1 minvalue 1 no maxvalue start with 1;

create table t_item_category
(
	id int8 not null primary key default nextval('item_category_serial_id'),
	item_id int8,
	category_id int8
);
create table t_item
(
	id int8 not null primary key default nextval('item_serial_id'),
	name varchar(256),
	price FLOAT4
);
create table t_category
(
	id int8 not null primary key default nextval('category_serial_id'),
	name varchar(256)
);

insert into t_item_category(item_id, category_id) values(1, 1);
insert into t_item_category(item_id, category_id) values(2, 1);
insert into t_item_category(item_id, category_id) values(3, 2);
insert into t_item_category(item_id, category_id) values(4, 3);
insert into t_item(name, price) values('Reebok GL 6000 ND', 532.1);
insert into t_item(name, price) values('Reebok AZTEC RETRO', 458.3);
insert into t_item(name, price) values('Reebok WOR WVN JACKET', 124.5);
insert into t_item(name, price) values('Reebok EL BLUEY COLLAB SHORT', 781.6);
insert into t_category(name) values('鞋 ');
insert into t_category(name) values('衣服 ');
insert into t_category(name) values('裤子');