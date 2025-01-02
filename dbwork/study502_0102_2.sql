 -- 데이타타입
--    문자 : char,varchar
--    숫자 :  tinyint  1 byte
--           smallint  2byte
--           mediumint 3byte
--           int       4byte
--           bigint    8byte
--           float     실수타입 4byte
--           double      "      8byte
--           decimal(m,n) : m 자리수, n 소숫점자릿수
-- 	날짜 :    date   CCYY-MM-DD  :now() 로 저장한다해도 날짜만 저장된다
--           datetime   CCYY-MM-DD hh:mm:ss : now() 로 저장하면 날짜와 시간이저장된다
--           timestamp     "
--           time          hh:mm:ss
--           year        CCYY 또는 YY

CREATE table person (
	num smallint AUTO_INCREMENT PRIMARY KEY,
    name varchar(20),
    blood varchar(10) default 'B',
    age smallint,
	today date,
    writeday datetime);
    
-- table 구조 확인
desc person;
show create table person; -- 좀 더 디테일한 구조 확인

-- 데이터 추가하기
insert into person (name, age, today, writeday) values ('이영자', 23, now(), now());
-- 모든 필드명 생략하고 순서대로 넣기 / num은 시퀀스 필드이므로 null 로 줘도 숫자 알아서 들어감
insert into person values (null, '강호동', 'AB', 45, now(), now());
insert into person values (null, '유재석', 'O', 19, now(), now());
insert into person values (null, '고릴라', 'A', 22, now(), now());
insert into person values (null, '이효리', 'AB', 39, now(), now());
insert into person values (null, '손진아', 'B', 29, now(), now());

-- 각종 조회 연습
select num, name, age from person order by age asc;
select num, name, age from person order by age desc;
select * from person where age >= 20 and age <= 30;
select * from person where blood in('A', 'B', 'AB');
select * from person where name like '강%';
select * from person where name like '%영%';
select * from person where name like '_진%';

-- 그룹함수 : count, avg, sum, max, min
select count(*) from person;
select avg(age) from person;
select round(avg(age), 0) from person;
select sum(age) from person;
select min(age) from person;
select max(age) from person;

-- 혈액형 별 인원 수와 평균 나이
select blood, count(*) 인원수, round(avg(age), 0) 평균나이 
from person group by blood order by blood;

-- limit 시작위치, 가져올 글의 개수
select * from person limit 0, 3; -- 첫 글(0번)부터 3개만 가져오기
select * from person limit 2, 3; -- 2번 글부터 3개만 가져오기

-- where 조건과 limit 사용 시
select * from person where age >= 25 limit 1, 2; -- 검색된 결과에서 limit 수행

-- update
update person set blood = '0', age = 18 where name = '고릴라';
-- You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  
-- To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.

-- delete
delete from person where name = '강호동';


