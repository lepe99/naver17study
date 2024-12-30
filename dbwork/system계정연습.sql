-- system 에 등록된 table들 확인하기
-- 커서가 있는 곳의 SQL문 실행 단축키 ctrl + 엔터
SELECT * FROM TAB; -- * : 전체 조회

-- 등록된 user(계정)들 확인 해 보기
SELECT username FROM dba_users; -- dba_users 테이블에서 username 이라는 컬럼만 확인

-- dba_users 라는 테이블에는 어떤 컬럼이 있을까
DESC dba_users; -- 기본 구조만 확인(데이터는 확인 안됨)

-- 계정과 lock 상태 알아보기
SELECT username, account_status FROM dba_users;

-- scott 계정의 비밀번호를 tiger 로 생성 해 보기
CREATE USER scott IDENTIFIED BY tiger; -- 12버전부터 오류 발생

-- 12 버전 부터는 user명에 공통 문자열 c##이 들어가야 한다
CREATE USER c##scott IDENTIFIED BY tiger;

-- c##scott 삭제
DROP USER c##scott;

-- 공통문자열 없이 생성할 수 있는 방법으로 생성하여 보자
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE; -- SESSION 변경

-- 공통문자열 c## 없이 다시 생성해보기 (SCOTT / TIGER)
CREATE USER scott IDENTIFIED BY tiger;

-- angel / a1234 로 만들어 보자
CREATE USER angel IDENTIFIED BY a1234;

-- angel 계정에 lock 설정
ALTER USER angel ACCOUNT LOCK;

-- '' lock 설정 해제
ALTER USER angel ACCOUNT UNLOCK;

-- scott와 angel 계정에 기본 권한을 주자
-- connect : 접속할 수 있는 권한
-- resource : 데이터 관리를 할 수 있는 권한
GRANT CONNECT, RESOURCE TO angel;
GRANT CONNECT, RESOURCE TO scott;

-- 생성된 계정에서 테이블을 생성하고 데이터를 추가하려고 하면 table space 에 대한 오류 발생
-- table space 를 unlimit로 설정 (system 계정에서만 할 수 있음)
ALTER USER angel DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;
ALTER USER scott DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;

-- angel 의 비번을 a1234 에서 pw1234 로 변경
ALTER USER angel IDENTIFIED BY pw1234;