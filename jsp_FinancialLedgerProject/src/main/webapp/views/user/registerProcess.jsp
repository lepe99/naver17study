<%-- registerProcess.jsp --%>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="dto.UsersDto" %>
<%@ page import="dao.UsersDao" %><%@ page import="dao.UserBalancesDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String loginId = request.getParameter("loginId");
    String password = request.getParameter("password");
    String username = request.getParameter("username");

    UsersDto dto = new UsersDto();
    dto.setLoginId(loginId);
    dto.setPassword(password);
    dto.setUsername(username);

    try {
        UsersDao dao = new UsersDao();
        UserBalancesDao balanceDao = new UserBalancesDao();
        dao.createUser(dto);
        int userId = balanceDao.getUserIdByLoginId(loginId);
        balanceDao.insertUserBalance(userId);

    // json 응답
        JSONObject json = new JSONObject();
        json.put("success", true);
        json.put("message", "회원가입 성공, 로그인 페이지로 이동합니다.");
        out.print(json.toJSONString());
    } catch (Exception e) {
        JSONObject json = new JSONObject();
        json.put("success", false);
        json.put("message", "회원가입 실패, 아이디 중복 여부를 확인해주세요");
        out.print(json.toJSONString());
    }

%>