<%-- categoryList.jsp --%>
<%@ page import="dto.UsersDto"%>
<%@ page import="dao.CategoriesDao"%>
<%@ page import="dto.CategoriesDto"%>
<%@ page import="java.util.List"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    UsersDto userDto = (UsersDto) session.getAttribute("loginUser");
    int userId = userDto.getUserId();

    CategoriesDao dao = new CategoriesDao();
    List<CategoriesDto> dto = dao.getCategories(userId);

    JSONArray arr = new JSONArray();
    for (CategoriesDto category : dto) {
        JSONObject obj = new JSONObject();
        obj.put("id", category.getId());
        obj.put("name", category.getName());
        obj.put("categoryType", category.getCategoryType());
        arr.add(obj);
    }
    out.print(arr.toJSONString());
%>
