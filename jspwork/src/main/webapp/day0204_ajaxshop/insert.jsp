<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dto" class="shop.data.ShopDto"/>
<jsp:useBean id="dao" class="shop.data.ShopDao"/>
<jsp:setProperty name="dto" property="*"/>
<%
    dao.insertData(dto);
%>