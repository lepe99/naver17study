create table simple_board
(
    num        smallint auto_increment primary key,
    writer     varchar(20),
    subject    varchar(1000),
    content    varchar(2000),
    read_count smallint default 0,
    write_date datetime
);

alter table simple_board
    change num board_id smallint auto_increment;


create table simple_comment
(
    comment_idx smallint auto_increment primary key,
    board_id    smallint,
    writer      varchar(20),
    content     varchar(1000),
    write_date  datetime,
    constraint fk_comment_board_id foreign key (board_id)
        references simple_board (board_id) on delete cascade

);
-- 제약조건 안걸고 설정
-- foreign key (board_id) references simple_board (board_id) on delete cascade