<%--<%@ page import="simpleBoard.data.SimpleBoardDto" %>--%>
<%--<%@ page import="simpleBoard.data.SimpleBoardDao" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%--%>
<%--    // 1. 폼데이터 읽기--%>
<%--    String writer = request.getParameter("writer");--%>
<%--    String subject = request.getParameter("subject");--%>
<%--    String content = request.getParameter("content");--%>

<%--    // 2. dto 생성 후 데이터 생성자로 저장--%>
<%--    SimpleBoardDto dto = new SimpleBoardDto(writer, subject, content);--%>

<%--    // 3. dao 생성 후 insert 메소드 호출--%>
<%--    SimpleBoardDao dao = new SimpleBoardDao();--%>
<%--    dao.insertBoard(dto);--%>

<%--    // 4. 페이지 이동 (boardList.jsp)--%>
<%--    response.sendRedirect("boardList.jsp");--%>
<%--%>--%>

<!-- jsp 에만 있는 javaBeans 기능 -->
<!-- 위의 주석 처리된 코드를 jsp:useBean, jsp:setProperty 로 대체 -->
<jsp:useBean id="dao" class="simpleBoard.data.SimpleBoardDao"/>
<jsp:useBean id="dto" class="simpleBoard.data.SimpleBoardDto"/>

<!-- dto 와 이름이 같은 폼 데이터를 읽어 dto 에 저장 -->
<!-- property="*" 는 dto 의 모든 멤버변수에 값을 저장하겠다는 의미 -->
<!-- 폼 데이터의 name 과 dto 의 멤버변수명이 같아야 함 -->
<jsp:setProperty name="dto" property="*"/>
<%
    dao.insertBoard(dto);
    response.sendRedirect("boardList.jsp");
%>