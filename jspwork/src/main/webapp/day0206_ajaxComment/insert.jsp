<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dto" class="comment.data.CommentDto"/>
<jsp:useBean id="dao" class="comment.data.CommentDao"/>
<jsp:setProperty name="dto" property="*"/>
<%
    dao.insertData(dto);
%>