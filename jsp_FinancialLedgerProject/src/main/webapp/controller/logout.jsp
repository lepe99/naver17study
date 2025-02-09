<%-- logout.jsp --%>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page language="java" contentType="applicaition/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    JSONObject json = new JSONObject();
    try {
        session.invalidate();
        json.put("success", true);
    } catch (Exception e) {
        json.put("success", false);
        json.put("message", "로그아웃 실패");
    } finally {
        out.print(json.toJSONString());
    }
%>