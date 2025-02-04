<%@ page import="org.json.simple.JSONObject" %>
<%@ page language="java" contentType="text/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String myName = request.getParameter("myName");

    JSONObject obj = new JSONObject();
    obj.put("name", myName);
    obj.put("address", "서울시 강남구");
    obj.put("hp", "010-1111-2222");

%>
    <%= obj.toString() %>