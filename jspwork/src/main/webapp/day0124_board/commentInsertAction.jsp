<!-- commentInsertAction.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dto" class="simpleBoard.data.SimpleCommentDto"/>
<jsp:useBean id="dao" class="simpleBoard.data.SimpleCommentDao"/>
<jsp:setProperty name="dto" property="*"/>

<%
    dao.insertComment(dto);
    response.sendRedirect("contentDetail.jsp?boardId=" + dto.getBoardId());
%>