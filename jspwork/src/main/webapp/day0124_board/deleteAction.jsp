<%@ page import="simpleBoard.data.SimpleBoardDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    int boardId = Integer.parseInt(request.getParameter("boardId"));
    SimpleBoardDao dao = new SimpleBoardDao();
    dao.deleteBoard(boardId);

    response.sendRedirect("boardList.jsp");
%>