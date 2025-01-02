-- 전체 table 확인하기
show tables;
-- 현재 날짜와 시간 구하기
SELECT now() FROM DUAL;
SELECT sysdate() FROM DUAL;
SELECT current_timestamp() FROM DUAL;

-- 날짜함수들
SELECT year(now()) FROM DUAL; -- 년, 숫자로 반환
SELECT month(now()) FROM DUAL; -- 월
SELECT day(now()) FROM DUAL; -- 일
SELECT dayofmonth(now()) FROM DUAL; -- 일
SELECT monthname(now()) FROM DUAL; -- 월을 영어로
SELECT dayname(now()) FROM DUAL; -- 요일

-- date_format(날짜, '형식') -> 오라클의 to_char
-- %Y 년도 4자리 / %y 년도 2자리 / %M 월을 영어로 / %m 월을 숫자로 / %d 날짜
SELECT date_format(now(), '%Y-%M-%d') FROM DUAL; -- 2025-January-02
SELECT date_format(now(), '%y-%m-%d') FROM DUAL; -- 25-01-02
-- %H 24시간 / %h 12시간 / %i 분
SELECT date_format(now(), '%Y-%m-%d %h:%i') FROM DUAL; -- 2025-01-02 15:02

-- 문자함수들
-- concat(a, b, c, ..) : 문자열 결합, 여러개 가능
SELECT concat('Happy', 'Day', '!!') FROM DUAL;
-- replace('문자열', '기존문자열', '대체문자열') : 문자열 변경
SELECT replace('bitcamp', 'bit', '비트') FROM DUAL;
-- instr('문자열', '찾는 문자열') : 위치 반환
SELECT instr('김영희', '영희') FROM DUAL; -- 2
SELECT instr('김영희', '철수') FROM DUAL; -- 0 (없음)

-- left('문자열', 갯수) : 왼쪽에서 추출
-- right('문자열', 갯수) : 오른쪽에서 추출
-- mid('문자열', 시작위치, 갯수) : 시작위치에서 갯수만큼 추출
-- substring('문자열', 시작위치, 갯수) : 시작위치부터 갯수만큼 추출
SELECT left('Have a nice day', 4) FROM DUAL;
SELECT right('Have a nice day', 3) FROM DUAL;
SELECT mid('Have a nice day', 8, 4) FROM DUAL;
SELECT substring('Have a nice day', 8, 4) FROM DUAL;

-- ltrim, rtrim, trim : 공백 제거
SELECT concat('*', ltrim('  nice  '), '*') FROM DUAL;
SELECT concat('*', rtrim('  nice  '), '*') FROM DUAL;
SELECT concat('*', trim('  nice  '), '*') FROM DUAL;

-- lower , lcase : 소문자 변환 / upper, ucase : 대문자 변환 / reverse : 거꾸로
SELECT lower('Have A nice DAY') FROM DUAL;
SELECT upper('Have A nice DAY') FROM DUAL;
SELECT lcase('Have A nice DAY') FROM DUAL;
SELECT ucase('Have A nice DAY') FROM DUAL;
SELECT reverse('Have A nice DAY') FROM DUAL;


-- 조건함수
-- if(조건, 참, 거짓)
SELECT if(100 > 200, '맞음', '틀림') FROM DUAL;
SELECT if(100 > 200, '맞음', '틀림') result FROM DUAL; -- 필드 이름 변경

-- ifnull(필드, null일 시 대치값) / 오라클의 NVL과 같다
SELECT ifnull(null, 1) FROM DUAL; -- 1
SELECT ifnull('mija', 1) FROM DUAL; 

-- 숫자함수
-- abs : 절대값
SELECT abs(6), abs(-6) FROM DUAL; 
-- ceiling : 올림 / floor : 내림 / round : 반올림
SELECT ceiling(3.6), floor(3.6), round(3.6) FROM DUAL; 
SELECT ceiling(3.4), floor(3.4), round(3.4) FROM DUAL; 

SELECT round(3.16, 1) FROM DUAL; -- 3.2
SELECT round(564653, -2) FROM DUAL; -- 564700

-- pow : 지수승 / mod : 나머지
SELECT pow(2, 3), mod(10, 3) FROM DUAL; 

-- greatest(n1, n2, ...) : 가장 큰 숫자 구하기 / least(n1, n2, ...) : 가장 작은 숫자 구하기
SELECT greatest(1, 2, 3, 4, 5), least(1, 2, 3, 4, 5) FROM DUAL; 

