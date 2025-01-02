-- PL-SQL : SQL 언어에 절차적 언어요소를 추가하여 프로그래밍 한 것을 말함
-- 형식
-- DECLARE
--     변수, 커서 선언
-- BEGIN
--     SQL 구문이나 PL/SQL 문으로 코딩
-- END;
-- / (실행)

-- 스크립트 출력창에 결과가 출력되도록 한번만 설정
SET SERVEROUTPUT ON -- 켜기
SET SERVEROUTPUT OFF -- 끄기 (DBMS 출력 창으로 확인할거임)


-----------------------------------------------------------------------------


-- 예제 1
DECLARE
    v_no NUMBER(4, 1); -- 변수 선언
BEGIN
    v_no := 12.7; -- 값 대입 (오라클에서 = 은 비교 연산자, := 은 대입 연산자)
    dbms_output.put_line(v_no); -- 콘솔창에 출력
END;
/


-----------------------------------------------------------------------------


-- 예제 2
DECLARE
    vcolor VARCHAR2(20);
    vprice NUMBER(10);
    vprdt VARCHAR2(20);
BEGIN
    vcolor := '오렌지색';
    vprice := 35000;
    vprdt := '모직코트';
    
    dbms_output.put_line('상품명 : ' || vprdt);
    dbms_output.put_line('가격 : ' || vprice || '원');
    dbms_output.put_line('색상 : ' || vcolor);
END;
/


-----------------------------------------------------------------------------


-- 예제 3
DECLARE
    vscode VARCHAR2(20);
    vsprice NUMBER(10);
    vsprdt VARCHAR2(30);
BEGIN
    vscode := 'A300';
    
    -- vscode 값에 해당하는 상품 데이터 가져오기
    SELECT PRDTPRICE, PRDTNAME 
    INTO vsprice, vsprdt -- 해당 변수로 값을 가져오기
    FROM SHOP WHERE PRDTCODE = vscode;
    
    dbms_output.put_line('상품명 : ' || vsprdt);
    dbms_output.put_line('가격 : ' || vsprice || '원');
    dbms_output.put_line('코드번호 : ' || vscode);
END;
/


-----------------------------------------------------------------------------


-- 예제 4 if문
DECLARE
    v_year NUMBER(4) := 2025;
    v_mod NUMBER(2) := mod(v_year, 12);
    v_ddi VARCHAR2(20); -- 띠 저장 할 변수
BEGIN
    if v_mod = 0 then v_ddi := '원숭이띠';
    elsif v_mod = 1 then v_ddi := '닭띠';
    elsif v_mod = 2 then v_ddi := '개띠';
    elsif v_mod = 3 then v_ddi := '돼지띠';
    elsif v_mod = 4 then v_ddi := '쥐띠';
    elsif v_mod = 5 then v_ddi := '소띠';
    elsif v_mod = 6 then v_ddi := '호랑이띠';
    elsif v_mod = 7 then v_ddi := '토끼띠';
    elsif v_mod = 8 then v_ddi := '용띠';
    elsif v_mod = 9 then v_ddi := '뱀띠';
    elsif v_mod = 10 then v_ddi := '말띠';
    elsif v_mod = 11 then v_ddi := '양띠';
    end if;
    
    dbms_output.put_line(v_year || '년도는 ' || v_ddi || '해 이다');
END;
/


-----------------------------------------------------------------------------


-- 예제 5 accept
-- accept 를 이용하여 년도를 직접 입력해 띠를 알아보자
ACCEPT year PROMPT '년도를 입력해주세요';
DECLARE
    v_year NUMBER(4) := '&year'; -- 입력받은 year 값 가져오기
    v_mod NUMBER(2) := mod(v_year, 12);
    v_ddi VARCHAR2(20); -- 띠 저장 할 변수
BEGIN
    if v_mod = 0 then v_ddi := '원숭이띠';
    elsif v_mod = 1 then v_ddi := '닭띠';
    elsif v_mod = 2 then v_ddi := '개띠';
    elsif v_mod = 3 then v_ddi := '돼지띠';
    elsif v_mod = 4 then v_ddi := '쥐띠';
    elsif v_mod = 5 then v_ddi := '소띠';
    elsif v_mod = 6 then v_ddi := '호랑이띠';
    elsif v_mod = 7 then v_ddi := '토끼띠';
    elsif v_mod = 8 then v_ddi := '용띠';
    elsif v_mod = 9 then v_ddi := '뱀띠';
    elsif v_mod = 10 then v_ddi := '말띠';
    elsif v_mod = 11 then v_ddi := '양띠';
    end if;
    
    dbms_output.put_line(v_year || '년도는 ' || v_ddi || '해 이다');
END;
/


-----------------------------------------------------------------------------


-- 예제 6 : 상품코드, 상품명, 가격을 입력 받아 shop 테이블에 추가
ACCEPT scode PROMPT 'A로 시작하는 상품코드를 입력해주세요';
ACCEPT sprdt PROMPT '상품명을 입력해주세요';
ACCEPT sprice PROMPT '상품의 가격을 입력해주세요';

DECLARE
    v_code VARCHAR2(20) := '&scode';
    v_prdt VARCHAR2(20) := '&sprdt';
    v_price NUMBER(10) := '&sprice';
BEGIN
    INSERT INTO SHOP(prdtcode, prdtname, prdtprice) VALUES (v_code, v_prdt, v_price);
    dbms_output.put_line(v_prdt || ' 상품정보를 테이블에 추가했습니다');
END;
/


-----------------------------------------------------------------------------


-- 예제 7 : Cursor 와 for문을 이용하여 shop 의 데이터 읽기
DECLARE
    --커서객체에 select sql 문을 이용해서 넣기
    CURSOR s1 IS
        SELECT * FROM shop;
BEGIN
    FOR s IN s1 LOOP  --record 단위로 s가 가져온다
        dbms_output.put_line(s.prdtcode || '   ' || s.prdtname || '   ' || s.prdtprice);
        EXIT WHEN s1%notfound; --더 이상 데이터가 없으면 for 문 탈출
    END LOOP;
END;



-----------------------------------------------------------------------------


-- 예제 8 : join 이용하여 cartnum, prdtcode, prdtname, prdtprice, cntnum,cartday 를 출력
DECLARE
    --커서 객체에 select 문을 이용
    CURSOR s1 IS
        SELECT CARTNUM, s.PRDTCODE, PRDTNAME, PRDTPRICE, CNTNUM, 
        TO_CHAR(CARTDAY, 'YYYY-MM-DD') CARTDAY
        FROM SHOP s, CART c
        WHERE s.PRDTCODE = c.PRDTCODE;
BEGIN
    FOR s IN s1 LOOP  --record 단위로 s가 가져온다
        dbms_output.put_line(s.cartnum || ' ' || s.prdtcode || ' ' || s.prdtname
        || ' ' || s.prdtprice || '  ' || s.cntnum || '  ' || s.cartday);
        EXIT WHEN s1%notfound; --더이상 데이타가 없으면 for문을 빠져나가라
    END LOOP;
END;
/


-----------------------------------------------------------------------------


-- 예제 9 상품코드와 상품명과 가격을 accept를 이용해서 입력
-- shop에 해당 상품코드가 존재할경우 update로 수정 / 존재하지 않을겨우 insert로 추가
ACCEPT scode PROMPT 'A로 시작하는 상품코드를 입력하세요';
ACCEPT sprdt PROMPT '상품명을 입력하세요';
ACCEPT sprice PROMPT '가격을 입력하세요';

DECLARE
    v_code VARCHAR2(20) :='&scode';
    v_prdt VARCHAR2(30) := '&sprdt';
    v_price NUMBER(10) := '&sprice';
    v_cnt NUMBER(2); -- count 값을 가져올 변수    
BEGIN
    SELECT COUNT(*) INTO v_cnt
    FROM shop WHERE prdtcode = v_code; --존재하면 1, 존재하지 않으면 0
    
    IF v_cnt = 1 THEN
        UPDATE shop SET prdtname = v_prdt, prdtprice = v_price
        WHERE prdtcode = v_code;
        COMMIT;
        dbms_output.put_line(v_code || '상품이 수정되었습니다');
    ELSE
        INSERT INTO shop (prdtcode, prdtname, prdtprice) VALUES
        (v_code, v_prdt, v_price);
        COMMIT;
        dbms_output.put_line(v_code || '상품이 추가되었습니다');
    END IF;   
END;
/


-----------------------------------------------------------------------------


-- 예제 10 : 상품명을 입력하면 shop 테이블에서 그 이름을 포함하고 있는 데이터들을 모두 출력
ACCEPT sprdt PROMPT '상품명을 입력하세요';

DECLARE
    v_prdt VARCHAR2(30) := '&sprdt';
    CURSOR s1 IS
        SELECT * FROM shop WHERE prdtname LIKE '%' || v_prdt || '%';
    v_cnt NUMBER(2);
BEGIN
    SELECT COUNT(*) INTO v_cnt
    FROM shop WHERE prdtname LIKE '%' || v_prdt || '%';
    IF v_cnt = 0 THEN
        dbms_output.put_line(v_prdt || '상품은 존재하지 않습니다');
    ELSE
        dbms_output.put_line('상품코드    상품명     상품가격');
        dbms_output.put_line('-------------------------');
        FOR s IN s1 LOOP
            dbms_output.put_line(s.prdtcode || '   ' || s.prdtname || '   ' || s.prdtprice);
            EXIT WHEN s1%notfound;
        END LOOP;
    END IF;
END;
/