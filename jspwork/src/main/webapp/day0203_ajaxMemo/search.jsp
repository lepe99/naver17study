<%@ page import="memo.data.MemoDto" %>
<%@ page import="memo.data.MemoDao" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String search = request.getParameter("search");

    MemoDao dao = new MemoDao();
    List<MemoDto> list = dao.getAllData(0, search);
%>