-- 12월 30일 oracle SQL 문제

-- 1. 어떤 종류의 직업이 있는지 job 을 한 번 씩만 출력 (오름차순 정렬)
SELECT DISTINCT job FROM emp ORDER BY job;

-- 2. ename에 대소문자 상관없이 's'를 포함하고 있는 데이터출력(필드 : ename, job, sal)
SELECT ename, job, sal FROM emp WHERE ename LIKE '%S%' OR ename LIKE '%s%';

-- 3. ename의 3번째 글자가 L인 사람을 조회 (필드 : ename, sal, comm)
SELECT ename, sal, comm FROM emp WHERE SUBSTR(ename, 3, 1) = 'L';

-- 4. comm이 null 이 아닌 사람중에 sal이 1500 이상인 사람 출력 (필드 : ename, sal, comm)
SELECT ename, sal, comm FROM emp WHERE comm IS NOT NULL AND sal >= 1500;

-- 5. hiredate 가 5월인 사람 모두 출력 (필드 : ename, hiredate, sal)
SELECT ename, hiredate, sal FROM emp WHERE TO_CHAR(hiredate, 'MM') = 05;

-- 6. hiredate 가 1985-01-01 이후인 사람 모두 출력 (필드 : ename, hiredate, sal)
SELECT ename, hiredate, sal FROM emp WHERE TO_DATE(hiredate) > TO_DATE('1985-01-01');
SELECT ename, hiredate, sal FROM emp WHERE TO_CHAR(hiredate, 'YYYY-MM-DD') > '1985-01-01';
SELECT ename, hiredate, sal FROM emp WHERE hiredate > '1985-01-01';

-- 7. sal이 1500~3000 사이인 사람을 출력 (관계연산자, and 이용, 필드 : ename, sal, mgr)
SELECT ename, sal, mgr FROM emp WHERE sal >= 1500 AND sal <= 3000;

-- 8. 7번을 between 이용하여 출력
SELECT ename, sal, mgr FROM emp WHERE sal BETWEEN 1500 AND 3000;

-- 9. in 을 이용해 job이 clerk, president, manager인 사람의 전체 필드를 모두 출력
SELECT * FROM emp WHERE job in ('CLERK', 'PRESIDENT', 'MANAGER');

--10. ename, sal, comm, sal*comm 을 출력, comm 이 null 인 경우 1로 변경하여 출력
SELECT ename, sal, comm, sal * NVL(comm, 1) FROM emp;

--11. ename이 ADAMS인 사람의 sal보다 더 많이 받는 사람 출력 (필드 : ename, job, sal)
SELECT ename, job, sal FROM emp 
WHERE sal > (SELECT sal FROM emp WHERE ename = 'ADAMS');

--12. 평균 sal보다 작은 사람의 전체 컬럼 출력
SELECT * FROM emp WHERE sal < (SELECT AVG(sal) FROM emp);

--13. ename이 a나 s나 m으로 시작하는 모든 사람 출력 (필드 : ename, job, sal)
SELECT ename, job, sal FROM emp WHERE SUBSTR(ename, 1, 1) IN ('A', 'S', 'M');

--14. mgr을 group으로 묶어 인원수와 평균sal 구하기 (평균은 무조건 올림)
SELECT mgr, count(*) 인원수, CEIL(AVG(sal)) 평균연봉 FROM emp GROUP BY mgr;

--15. SCOTT 의 sal 과 같은 sal을 받는 사람을 조회 (필드 : ename, sal)
SELECT ename, sal FROM emp 
WHERE sal = (SELECT sal FROM emp WHERE ename = 'SCOTT');

--16. ename의 글자길이가 4글자인 사람만 조회(필드 : ename, job)
SELECT ename, job FROM emp WHERE LENGTH(ename) = 4;

--17. ename의 3번째 글자가 r이거나 a인 사람 조회(필드 : ename, job)
SELECT ename, job FROM emp WHERE SUBSTR(ename, 3, 1) IN('R', 'A');

--18. job 직업별로 인원수와 최고연봉을 출력 (직업의 오름차순 정렬)
SELECT job 직업, COUNT(*) 인원수, MAX(sal) 최고연봉 FROM emp 
GROUP BY job ORDER BY job;

--19. || 연산자 이용하여 다음과 같이 하나의 필드 출력
---- (예) SCOTT의 직업은 CLERK이며 입사년도는 1985년 05월 입니다 (필드명 : 자기소개)
SELECT LPAD(ename, 6, ' ') || '의 직업은 ' || LPAD(job, 9, ' ') || '이며 입사년도는 ' || 
TO_CHAR(hiredate, 'YYYY') || '년 ' || TO_CHAR(hiredate, 'MM') || '월 입니다' 자기소개 FROM emp;
