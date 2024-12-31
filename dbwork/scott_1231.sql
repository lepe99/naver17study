-- EQUI JOIN 또는 INNER JOIN : 두 테이블의 결합

-- 방법 1 : 필드명 앞에 테이블명이나 테이블 별칭을 붙임
SELECT E.ename, E.job, E.sal, D.dname, D.loc
FROM emp E, dept D
WHERE E.deptno = D.deptno;

-- 방법 2 : 조인 할 테이블에 필드명이 겹치지 않는 경우는 테이블명이나 별칭을 붙이지 않아도 된다.
SELECT ename, job, sal, dname, loc, D.deptno -- deptno는 겹치므로 붙여줘야 함
FROM emp E, dept D
WHERE E.deptno = D.deptno;

-- DECODE 함수 - 다중 IF문 같이 쓰이는 함수
SELECT ename, deptno, DECODE(deptno, 10, '홍보부', deptno, 20, '교육부', deptno, 30, '인사부') 부서명
FROM EMP;