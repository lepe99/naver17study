create table study502.shop (
    idx smallint auto_increment primary key,
    prdt varchar(30),
    num smallint default 1,
    price int,
    indate datetime);