<%-- addCategory.jsp --%>
<%@ page import="dto.CategoriesDto"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="dao.CategoriesDao"%>
<%@ page import="dto.UsersDto"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    UsersDto userDto = (UsersDto) session.getAttribute("loginUser");
    int userId = userDto.getUserId();
    String name = request.getParameter("name");
    String categoryType = request.getParameter("categoryType");

    CategoriesDto dto = new CategoriesDto();
    dto.setUserId(userId);
    dto.setName(name);
    dto.setCategoryType(categoryType);

    JSONObject json = new JSONObject();
    try{
        CategoriesDao dao = new CategoriesDao();
        dao.createCategory(dto);
        json.put("success", true);
        json.put("message", "카테고리를 추가하였습니다.");
    } catch (Exception e) {
        json.put("success", false);
        json.put("message", "카테고리 추가에 실패했습니다.");
    }
    out.print(json.toJSONString());
%>