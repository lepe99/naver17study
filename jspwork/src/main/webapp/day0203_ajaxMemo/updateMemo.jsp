<%@ page import="memo.data.MemoDto" %>
<%@ page import="memo.data.MemoDao" %>
<%@ page import="java.util.List" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page language="java" contentType="text/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    int idx = Integer.parseInt(request.getParameter("idx"));
    MemoDao dao = new MemoDao();
    List<MemoDto> list = dao.getAllData(idx, null);
    MemoDto dto = list.get(0);

    JSONObject obj = new JSONObject();
    obj.put("idx", dto.getIdx());
    obj.put("avatar", dto.getAvatar());
    obj.put("nickname", dto.getNickname());
    obj.put("message", dto.getMessage());
%>
<%= obj %>