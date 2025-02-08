<%-- setDate.jsp --%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    int year = Integer.parseInt(request.getParameter("year"));
    int month = Integer.parseInt(request.getParameter("month"));

    JSONObject json = new JSONObject();
    try{
        session.setAttribute("year", year);
        session.setAttribute("month", month);
        json.put("success", true);
    } catch (Exception e) {
        json.put("success", false);
        json.put("message", "세션에 날짜 설정 실패");
    } finally {
        out.print(json.toJSONString());
    }
%>