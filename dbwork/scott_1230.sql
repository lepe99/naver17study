-- emp 테이블로 연습
-- job 필드의 데이터 중 중복되는 데이터는 제거
SELECT DISTINCT job FROM emp;
SELECT DISTINCT job,ename FROM emp;-- 다른 필드하고 같이 쓸 경우 적용이 안되거나 오류가 날 수도 있다
SELECT * from emp; --전체 필드 조회
SELECT ename,job FROM emp; --일부 필드만 조회
SELECT ename,job FROM emp ORDER BY ename; -- ename 의 오름차순 조회(asc 인경우는 생략)
SELECT ename,job FROM emp ORDER BY ename DESC;-- ename의 내림차순 조회(desc 인경우는 생략안됨)

-- job 의 오름차순,같은 job 일경우는 ename 의 내림차순 조회
SELECT job,ename FROM emp ORDER BY job,ename DESC;
-- job 의 오름차순,같은 job 일경우는 ename 도 오름차순 조회
SELECT job,ename FROM emp ORDER BY job,ename;
--순서를 정할때 필드명 대신 필드번호로 해도 된다(첫번째 컬럼은 1)
SELECT job,ename FROM emp ORDER BY 1,2; -- job(1),ename(2)

--sal 의 오름차순 정렬
SELECT * FROM emp ORDER BY 6;
SELECT * FROM emp ORDER BY sal;

--empno 의 오름차순 조회
SELECT ename,sal,comm,job,empno FROM emp ORDER BY 5;
SELECT ename,sal,comm,job,empno FROM emp ORDER BY empno;

-- ename 의 내림차순
SELECT ename,sal,comm,job,empno FROM emp ORDER BY 1 DESC;
SELECT ename,sal,comm,job,empno FROM emp ORDER BY ename DESC;

-- where 조건문
SELECT ename, job, sal, comm FROM emp WHERE sal >= 1500;
SELECT ename, job, sal, comm FROM emp WHERE ename = 'ALLEN'; -- 데이터 비교 시 대소문자 정확히 작성해야 뜸
 
-- ename이 A로 시작하는 데이터 조회
SELECT ename, job, sal, comm FROM emp WHERE ename LIKE 'A%'; -- % 사용

-- ename이 A를 포함하는 데이터 조회
SELECT ename, job, sal, comm FROM emp WHERE ename LIKE '%A%';

-- ename이 A로 시작하거나 S로 시작하는 데이터 조회
SELECT ename, job, sal, comm FROM emp WHERE ename LIKE 'A%' OR ename LIKE 'S%';
-- 논리 연산자 사용시 조건문 전문 양식 그대로 사용

-- ename이 A와 S를 모두 포함하는 데이터 조회
SELECT ename, job, sal, comm FROM emp WHERE ename LIKE '%A%' AND ename LIKE '%S%';

-- ename의 두번째 글자가 A인 사람만 데이터 조회
SELECT ename, job, sal, comm FROM emp WHERE ename LIKE '_A%'; -- _(언더바) 사용

-- ename의 두번째 글자나 세번째 글자가 A인 데이터 조회
SELECT ename, job, sal, comm FROM emp WHERE ename LIKE '_A%' OR ename LIKE '__A%';

-- ename이 N 또는 K로 끝나는 데이터 조회
SELECT ename, job, sal, comm FROM emp WHERE ename LIKE '%N' OR ename LIKE '%K';

-- job이 analyst 이면서 sal이 1500 이상인 사람의 데이터 조회
SELECT ename, job, sal, comm FROM emp WHERE job = 'ANALYST' AND sal >= 1500;

-- sal 1200 ~ 2000 사이
SELECT ename, job, sal, comm FROM emp WHERE sal <= 2000 AND sal >= 1200; -- 방법 1
SELECT ename, job, sal, comm FROM emp WHERE sal BETWEEN 1200 AND 2000; -- 방법 2

-- job이 manager,salesman,analyst 3가지
SELECT ename, job, sal, comm FROM emp WHERE job = 'ANALYST' OR job = 'SALESMAN' OR job = 'MANAGER'; -- 방법 1
SELECT ename, job, sal, comm FROM emp WHERE job IN ('ANALYST', 'SALESMAN', 'MANAGER'); -- 방법 2

-- empno 가 7654, 7788, 7844, 7902
SELECT empno, ename, job, sal, comm FROM emp WHERE empno IN (7654, 7788, 7844, 7902);

-- comm이 null 인 데이터만 조회
SELECT ename, job, sal, comm FROM emp WHERE comm IS NULL;

-- comm이 null이 아닌 데이터만 조회
SELECT ename, job, sal, comm FROM emp WHERE comm IS NOT NULL;

-- mgr 이 null이 아닌 경우
SELECT * FROM emp WHERE mgr IS NOT NULL;

-- mgr, comm이 null 인 경우 100, 0 으로 출력
SELECT ename, job, sal, NVL(mgr, 100), NVL(comm, 0) FROM emp; -- NVL

SELECT sal, comm, sal + comm FROM emp; -- comm 이 null일 경우 sal + comm 도 null
-- comm이 null이면 0으로 취급해서 구해보자
SELECT sal, comm, sal + NVL(comm, 0) FROM emp;

-- 필드명에 별칭 추가 (alias, 큰따옴표 사용!)
SELECT ename AS "사원명", sal AS "월급여" FROM emp; -- 생략 없이 지정
SELECT ename "사원명", sal "월급여" FROM emp; -- as 생략하며 alias 지정
SELECT ename 사원명, sal 월급여 FROM emp; -- alias 에 공백이 없는 경우 큰따옴표도 생략 가능
SELECT ename "사원 이름", sal "월 급여" FROM emp; -- 중간에 공백 있는경우 반드시 큰따옴표 같이 작성

-- 총 레코드 개수 (데이터 개수)
SELECT COUNT(*) FROM emp; -- 이 경우 필드명이 count(*)
SELECT COUNT(*) count FROM emp; -- 이 경우 필드명이 count / 자바랑 연동할 때 많이 쓸 예
SELECT COUNT(*) "총 갯수" FROM emp;

SELECT sal, comm, sal + NVL(comm, 0) sum FROM emp; -- 3번 필드의 컬럼명이 sum으로 대체
SELECT sal 월급여, comm 커미션, sal + NVL(comm, 0) 총금액 FROM emp;

-- 문자열을 컬럼에 추가 시 || 연산자 사용
SELECT '내 이름은 ' || ename || '입니다' 자기소개 FROM emp;

SELECT '내 직업은 ' || job || '이고 내 월 급여는 ' || sal || '입니다' 자기소개 FROM emp;

-- sal 이 1500 ~ 2000 사이가 아닌 경우만 조회
SELECT * FROM emp WHERE sal NOT BETWEEN 1500 AND 2000;

-- not in 사용하여 job이 salesman, clerk가 아닌 경우 조회
SELECT * FROM emp WHERE job NOT IN ('SALESMAN', 'CLERK');

-- GROUP 함수 (count, sum, avg, max, min, stddev 표준편차)
SELECT COUNT(*) FROM emp; -- 전체 레코드 개수
SELECT SUM(sal) FROM emp; -- sal의 총 합계
SELECT AVG(sal) FROM emp; -- 전체 sal의 평균
SELECT ROUND(AVG(sal), 2) FROM emp; -- 전체 sal의 평균, round로 소숫점 이하 두자리 까지 반올림하여 반환
SELECT MIN(sal), MAX(sal) FROM emp; -- 전체 sal의 최소, 최댓값

-- 평균 급여보다 sal이 더 높은 사람을 조회하시오
SELECT * FROM emp 
WHERE sal > (SELECT AVG(sal) FROM emp); -- 서브쿼리 이용함 !

-- scott 의 직업과 같은 직업을 가진 사람을 조회하시오
SELECT * FROM emp 
WHERE job = (SELECT job FROM emp WHERE ename = 'SCOTT');

-- scott 의 mgr과 같은 mgr을 가진 사람
SELECT * FROM emp
WHERE mgr = (SELECT mgr FROM emp WHERE ename = 'SCOTT');

-- GROUP BY
SELECT job FROM emp GROUP BY job; -- job이 그룹별로 나열

-- job의 그룹 별로 인원 수를 구해 보자
SELECT job, COUNT(*) FROM emp GROUP BY job;

-- 제먹에 별칭 부여
SELECT job 직업, COUNT(*) 인원수 FROM emp GROUP BY job;

-- job의 그룹 별 인원 수 (인원이 3명 이상인 경우에만)
SELECT job 직업, COUNT(*) 인원수 FROM emp GROUP BY job HAVING COUNT(JOB) >= 3;

-- job의 그룹 별 인원 수 (인원이 3명 이상인 경우에만, 인원순으로 출력(오름차순))
SELECT job 직업, COUNT(*) 인원수 FROM emp 
GROUP BY job HAVING COUNT(JOB) >= 3 ORDER BY COUNT(*); -- count(*) 대신 2 또는 인원수 와도 됨

-- 직업 별 인원수, 최저 연봉, 최고 연봉, 평균 연봉(소숫점 반올림) 을 구하시오
SELECT job 직업, COUNT(*) "인원 수", MIN(sal) "최저 연봉", MAX(sal) "최고 연봉", ROUND(AVG(sal), 0) "평균 연봉" 
FROM emp GROUP BY job ORDER BY 직업;

-- ppt 48p 숫자함수
SELECT ABS(-5), ABS(5) from DUAL; -- 절대값

SELECT ROUND(3.6, 0), CEIL(3.6), FLOOR(3.6) FROM DUAL; -- 반올림, 올림, 내림
SELECT ROUND(3.4, 0), CEIL(3.4), FLOOR(3.4) FROM DUAL;
SELECT ROUND(328947, -2) FROM DUAL; -- 십의 자릿수 반올림

SELECT ROUND(AVG(sal), 0), CEIL(AVG(sal)), FLOOR(AVG(sal)) FROM emp;

-- POWER(m, n) : m^n, MOD(m, n) : m%n
SELECT POWER(3, 3), MOD(10, 3) FROM DUAL; -- 거듭제곱, 나머지

-- 문자함수 concat : 문자열 더하기 / 원소 두 개, lower : 소문자로, upper : 대문자로, initcap : 첫 글자만 대문자로 강조
SELECT ename, CONCAT(ename, '님'), LOWER(ename), UPPER(ename), INITCAP(ename) FROM emp;

SELECT LPAD(sal, 10, '*') FROM emp; -- 총10자리, 남는 부분을 *로 채움 (왼쪽부터)
SELECT RPAD(sal, 10, '*') FROM emp; -- 총10자리, 남는 부분을 *로 채움 (오른쪽부터)

SELECT SUBSTR('HAPPY DAY', 7, 3) FROM DUAL; -- 7번 글자무터 3글자 추출
SELECT SUBSTR('HAPPY DAY', -6, 3) FROM DUAL; -- 뒤에서부터 6번째 글자무터 3글자 추출

-- emp 테이블의 ename에서 왼쪽에서 3글자를 추출 후 총 7자리 중 우측 빈공간은 *로 채워 출력
SELECT RPAD(SUBSTR(ename, 1, 3), 7, '*') FROM emp;

-- length 길이 구하기
SELECT ename 이름, LENGTH(ename) 문자길이 FROM emp;

-- replace(기존 문자열, 문자열에서 변경할 부분, 변경할 내용) / 대치
SELECT REPLACE('HAPPY DAY', 'HAPPY', 'GOOD') FROM DUAL;

-- trim 앞 뒤 공백 제거
SELECT '*' || ' H A P P Y ' || '*' FROM DUAL;
SELECT '*' || TRIM(' H A P P Y ') || '*' FROM DUAL;

-- 날짜 함수
-- 현재 날짜를 나타내는 sysdate 
SELECT SYSDATE FROM DUAL;
SELECT SYSDATE + 7 FROM DUAL; -- 더하기, 빼기 가능
SELECT SYSDATE + 1 FROM DUAL; -- 내일 날짜

-- to_char 함수를 이용해 우너하는 날짜 모양으로 출력해 보자
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM DUAL;
-- mm : 월, mi : 분 (대소문자 상관 없음)
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI') FROM DUAL; -- am 혹은 pm 아무거나 쓰면 오전/오후 표시 
-- hh or hh12 : 12시간제, hh24 : 24시간제
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI') FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'MONTH') FROM DUAL; -- 12월 (로컬 형식마다 다르게 출력됨. 통일성 갖추기 힘들어 잘 사용 안함)

-- 현재 년도 4자리만 추출
SELECT TO_CHAR(SYSDATE, 'YYYY') FROM DUAL; -- 2024

-- 현재 월 추출
SELECT TO_CHAR(SYSDATE, 'MM') FROM DUAL;
SELECT TO_CHAR(TO_DATE('2024-05-10'), 'MM') FROM DUAL;
SELECT TO_CHAR(DATE '2024-05-10', 'MM') FROM DUAL;

-- emp 의 hiredate는 날짜타입
SELECT TO_CHAR(hiredate, 'YYYY-MM-DD') 입사일 FROM emp;