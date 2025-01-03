select * from person;

-- 테이블 구조 변경
-- 1. 컬럼 추가 hp
alter table  person add hp varchar(20);
-- 2. today 컬럼 제거
alter table person drop column today;
desc person; -- 구조 확인

-- 3. 타입 변경 name 을 바이트 20에서 30으로 변경
alter table person modify name varchar(30);

-- 4. writeday 를 today 로 수정
alter table person rename column writeday to today;

-- 5. hp 에 데어터 넣기
update person set hp = '010-9876-8745' where num = 6;


-- 6. join 연습용 테이블 생성하기
-- 부모테이블은 person 으로 하고 person 의 num 을 외부키로 갖는 stu 생성

create table stu (
    idx tinyint auto_increment primary key,
    num smallint,
    kor smallint default 0,
    eng smallint default 0,
    sum smallint,
    constraint fk_stu_num foreign key(num) references person(num) on delete cascade
    -- person 데이터 삭제 시 stu 에 추가된 데이터는 자동으로 채워짐
);

-- stu 에 데이터 추가하기
insert into stu (num, kor, eng) values (1, 100, 84);
insert into stu (num, kor, eng) values (2, 45, 45);
insert into stu (num, kor, eng) values (4, 87, 87);
insert into stu (num, kor, eng) values (5, 96, 27);
insert into stu (num, kor, eng) values (6, 94, 85);
insert into stu (num, kor, eng) values (7, 47, 38);

-- 전체 학생들의 sum 구하기
update stu set sum = kor + eng;

-- person 과 stu 를 join 해서 전체를 출력하는 방법
-- 방법 1
select * from  person p, stu s where p.num = s.num;
-- 방법 2
select name, blood, age, kor, eng, sum
from person p, stu s where p.num = s.num;
-- 방법 3
select name, blood, age, kor, eng, sum
from person p
inner join stu s on p.num = s.num;

-- stu 생성 시 on delete cascade 설정
-- person 에서 1번을 삭제하면 stu 에서도 같이 삭제됨
delete from person where num = 1;

-- stu 만 조회
select * from stu;

-- 자바 연결 연습용
select name, age, blood, hp, date_format(today, '%Y-%m-%d %H:%i') date from person;

select blood, count(*) count, round(avg(age), 1) avgage from person
group by blood order by count;

UPDATE person set blood = 'A' where num = 2;

select * from person;

insert into person (name, blood, age, hp, today) values ('재석재', 'AB', 65, '010-6128-3474', now());

select name, blood, age, hp from person where name LIKE '%재석%';
delete from person where name = '재석재';

update person set age = 'a', blood = 'b', hp = 'c' where name = 'd';