<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- 자바빈즈 사용 -->
<!-- useBean 으로 dao,dto 선언하고 setProperty 로 전체 데이터 읽기 -->
<jsp:useBean id="dao" class="simpleBoard.data.SimpleBoardDao"/>
<jsp:useBean id="dto" class="simpleBoard.data.SimpleBoardDto"/>
<jsp:setProperty name="dto" property="*"/>

<%
    //dao의 updateBoard 호출
    dao.updateBoard(dto);

    //상세보기로 이동
    response.sendRedirect("contentDetail.jsp?boardId=" + dto.getBoardId());
%>