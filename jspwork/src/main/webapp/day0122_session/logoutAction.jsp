<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    session.removeAttribute("isLogin");

    // 메인 페이지 이동
    response.sendRedirect("login.jsp");
%>