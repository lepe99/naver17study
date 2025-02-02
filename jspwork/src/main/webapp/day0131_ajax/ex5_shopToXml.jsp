<?xml version="1.0" encoding="utf-8" ?>
<%@ page import="shop.data.ShopDao" %>
<%@ page import="shop.data.ShopDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8" %>
<data>
    <%
        String search = request.getParameter("search");
        ShopDao dao = new ShopDao();
        List<ShopDto> list = dao.getAllData(search);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for (ShopDto dto : list) { %>
    <shop>
        <idx><%= dto.getIdx() %></idx>
        <prdt><%= dto.getPrdt() %></prdt>
        <num><%= dto.getNum()%></num>
        <price><%= dto.getPrice()%></price>
        <indate><%= sdf.format(dto.getInDate())%></indate>
    </shop>
    <% } %>
</data>