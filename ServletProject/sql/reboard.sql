create table studydb.reboard
(
    num       smallint auto_increment primary key, # 글 번호
    writer    varchar(30)  not null,               # 작성자
    photo     varchar(200),                        # 사진
    passwd    varchar(20)  not null,               # 비밀번호
    subject   varchar(500) not null,               # 제목
    content   varchar(2000),                       # 내용
    readcount smallint default 0,                  # 조회수
    writeday  datetime,                            # 작성일
    regroup   smallint,                            # 답글 그룹
    relevel   smallint,                            # 답글 단계
    restep    smallint                             # 답글 순서
);