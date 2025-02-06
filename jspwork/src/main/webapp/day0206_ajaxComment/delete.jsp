<%@ page import="comment.data.CommentDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    int idx = Integer.parseInt(request.getParameter("idx"));

    CommentDao dao = new CommentDao();
    dao.deleteData(idx);
%>