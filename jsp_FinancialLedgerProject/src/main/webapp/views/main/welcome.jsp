<%-- welcome.jsp --%>
<%@ page import="dao.UserBalancesDao"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="dto.UsersDto"%><%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    UsersDto dto = (UsersDto) session.getAttribute("loginUser");
    int userId = dto.getUserId();
    UserBalancesDao dao = new UserBalancesDao();
    boolean newUser = dao.isNewUser(userId);
    JSONObject json = new JSONObject();
    if (newUser) json.put("newUser", true);
    else json.put("newUser", false);

    out.print(json.toJSONString());
%>