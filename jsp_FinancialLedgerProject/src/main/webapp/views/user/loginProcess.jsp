<%@ page import="dao.UsersDao" %>
<%@ page import="dto.UsersDto" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String loginId = request.getParameter("loginId");
    String password = request.getParameter("password");


    UsersDao dao = new UsersDao();
    boolean isValid = dao.validateUser(loginId, password);

    // json 응답
    JSONObject json = new JSONObject();
    if (isValid) {
        UsersDto dto = dao.getUserByLoginId(loginId);
        HttpSession user = request.getSession();
        user.setAttribute("loginUser", dto);
        json.put("success", true);
    } else {
        json.put("success", false);
        json.put("message", "로그인 실패, 아이디와 비밀번호를 확인해주세요.");
    }
    out.print(json.toJSONString());
%>