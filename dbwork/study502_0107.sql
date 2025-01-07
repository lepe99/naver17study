create table restaurant
(
    num       smallint auto_increment primary key,
    foodname  varchar(30),
    foodprice int,
    foodsize  varchar(20) default '보통'
);

create table foodorder
(
    idx        smallint auto_increment primary key,
    num        smallint,
    ordername  varchar(20),
    ordercnt   smallint,
    bookingday datetime,
    constraint fk_foodorder_num foreign key (num) references restaurant (num)
);

alter table foodorder modify bookingday varchar(30);
alter table foodorder drop constraint fk_foodorder_num;
alter table foodorder add constraint fk_foodorder_num foreign key (num) references restaurant (num);
alter table foodorder add constraint fk_foodorder_num foreign key (num) references restaurant (num) on delete cascade;

select r.num, ordername, r.foodname, r.foodprice, r.foodsize, ordercnt, bookingday
from foodorder f
join restaurant r on r.num = f.num;

insert into restaurant (foodname, foodprice, foodsize) values ('짜장',5900,'보통');
insert into foodorder (num, ordername, ordercnt, bookingday) values (1,'김성태',5,'2025-01-09');