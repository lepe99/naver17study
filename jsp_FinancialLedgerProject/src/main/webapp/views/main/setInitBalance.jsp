<%-- setinitBalance.jsp --%>
<%@ page import="dto.UsersDto"%>
<%@ page import="dto.UserBalancesDto"%>
<%@ page import="dao.UserBalancesDao"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    System.out.println("1");
    int initBalance = Integer.parseInt(request.getParameter("initBalance"));
    System.out.println("2");
    UsersDto userDto = (UsersDto) session.getAttribute("loginUser");
    System.out.println("3");
    int userId = userDto.getUserId();
    JSONObject json = new JSONObject();
    try{
        UserBalancesDto dto = new UserBalancesDto();
        dto.setUserId(userId);
        dto.setInitBalance(initBalance);
        UserBalancesDao dao = new UserBalancesDao();
        dao.updateInitBalance(dto);
        json.put("success", true);
        json.put("message", "초기 잔고를 입력하였습니다.");
    } catch (Exception e) {
        json.put("success", false);
        json.put("message", "초기 잔고 입력에 실패했습니다.");
    } finally{
        out.print(json.toJSONString());
    }

%>
