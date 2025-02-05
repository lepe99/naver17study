<%@ page import="shop.data.ShopDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    ShopDao dao = new ShopDao();
    dao.deleteData(num);
%>