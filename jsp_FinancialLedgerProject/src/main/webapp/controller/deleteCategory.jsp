<%-- deleteCategory.jsp --%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="dao.CategoriesDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));

    JSONObject json = new JSONObject();
    try{
        CategoriesDao dao = new CategoriesDao();
        dao.deleteCategory(id);
        json.put("success", true);
        json.put("message", "카테고리를 삭제하였습니다.");
    } catch (Exception e) {
        json.put("success", false);
        json.put("message", "사용중인 카테고리는 삭제할 수 없습니다.");
    }
    out.print(json.toJSONString());
%>