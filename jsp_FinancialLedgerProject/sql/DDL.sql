create table studydb.transactions
(
    id               int auto_increment primary key,                                  # id
    user_id          smallint                   not null,                             # 사용자 id
    recurring_id     int       default 0,                                             # 반복 거래 id
    transaction_date date                       not null,                             # 거래일
    amount           int                        not null,                             # 금액
    description      varchar(255)               not null,                             # 거래 내용
    transaction_type enum ('income', 'expense') not null,                             # 거래 유형
    created_at       timestamp default current_timestamp,                             # 생성일
    updated_at       timestamp default current_timestamp on update current_timestamp, # 수정일
    category_id      smallint                   not null,                             # 카테고리 id
    foreign key (category_id) references studydb.categories (id),
    foreign key (user_id) references studydb.users (user_id) on delete cascade,
    foreign key (recurring_id) references studydb.recurring_transactions (id) on delete cascade
);

create table studydb.categories
(
    id            smallint auto_increment primary key,                             # id
    user_id       smallint                   not null,                             # 사용자 id
    name          varchar(50)                not null,                             # 카테고리 이름
    category_type enum ('income', 'expense') not null,                             # 카테고리 유형
    created_at    timestamp default current_timestamp,                             # 생성일
    updated_at    timestamp default current_timestamp on update current_timestamp, # 수정일
    foreign key (user_id) references studydb.users (user_id) on delete cascade,
    unique (user_id, name)
);

create table studydb.recurring_transactions
(
    id               int auto_increment primary key,                                  # id
    user_id          smallint                                      not null,          # 사용자 id
    amount           int                                           not null,          # 금액
    description      varchar(255)                                  not null,          # 거래 내용
    transaction_type enum ('income', 'expense')                    not null,          # 거래 유형
    start_date       date                                          not null,          # 시작일
    end_date         date,                                                            # 종료일
    frequency        enum ('daily', 'weekly', 'monthly', 'yearly') not null,          # 주기
    interval_value   smallint                                      not null,          # 간격
    created_at       timestamp default current_timestamp,                             # 생성일
    updated_at       timestamp default current_timestamp on update current_timestamp, # 수정일
    category_id      smallint                                      not null,          # 카테고리 id
    foreign key (category_id) references studydb.categories (id),
    foreign key (user_id) references studydb.users (user_id) on delete cascade
);

create table studydb.users
(
    user_id    smallint auto_increment primary key,                             # 사용자 id
    login_id   varchar(50)  not null unique,                                    # 사용자 이름
    password   varchar(255) not null,                                           # 비밀번호
    username   varchar(30)  not null,                                           # 사용자 닉네임
    created_at timestamp default current_timestamp,                             # 생성일
    updated_at timestamp default current_timestamp on update current_timestamp, # 수정일
    salt       varchar(255) not null                                            # salt
);

create table studydb.user_balances
(
    user_id         smallint primary key,                                            # 사용자 id
    init_balance    int not null,                                                    # 초기 잔액
    current_balance int not null,                                                    # 현재 잔액
    updated_at      timestamp default current_timestamp on update current_timestamp, # 수정일
    foreign key (user_id) references studydb.users (user_id) on delete cascade
);

# 금액은 원화만, 소숫점 고려하지 않음