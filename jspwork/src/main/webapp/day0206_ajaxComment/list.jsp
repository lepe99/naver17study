<%@ page import="comment.data.CommentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="comment.data.CommentDto" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    int order = Integer.parseInt(request.getParameter("order"));
    int num = Integer.parseInt(request.getParameter("num"));

    CommentDao dao = new CommentDao();
    List<CommentDto> list = dao.getAllData(order, num);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    JSONArray arr = new JSONArray();
    for (CommentDto dto : list) {
        JSONObject obj = new JSONObject();
        obj.put("idx", dto.getIdx());
        obj.put("num", dto.getNum());
        obj.put("star", dto.getStar());
        obj.put("message", dto.getMessage());
        obj.put("writeDate", sdf.format(dto.getWriteDate()));
        arr.add(obj);
    }
%>
<%= arr %>