<%@ page import="org.json.simple.JSONObject"%><%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    JSONObject json = new JSONObject();
    if (session.getAttribute("loginUser") == null) json.put("login", false);
    else json.put("login", true);
    out.print(json.toJSONString());
%>
