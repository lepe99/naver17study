<%@ page import="memo.data.MemoDao" %>
<%@ page import="java.util.List" %>
<%@ page import="memo.data.MemoDto" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page language="java" contentType="text/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String search = request.getParameter("search");

    MemoDao dao = new MemoDao();
    List<MemoDto> list = dao.getAllData(0, search);

    JSONArray arr = new JSONArray();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    for (MemoDto dto : list) {
        JSONObject obj = new JSONObject();
        obj.put("idx", dto.getIdx());
        obj.put("avatar", dto.getAvatar());
        obj.put("nickname", dto.getNickname());
        obj.put("message", dto.getMessage());
        obj.put("writeDate", sdf.format(dto.getWriteDate()));
        arr.add(obj);
    }
%>
<%= arr %>