<%@ page import="shop.data.ShopDao" %>
<%@ page import="java.util.List" %>
<%@ page import="shop.data.ShopDto" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page language="java" contentType="text/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    ShopDao dao = new ShopDao();
    List<ShopDto> list = dao.getData(0, num, null);
    ShopDto dto = list.get(0);

    JSONObject obj = new JSONObject();
    obj.put("num", dto.getNum());
    obj.put("prdtImg", dto.getPrdtImg());
    obj.put("prdtName", dto.getPrdtName());
    obj.put("prdtColor", dto.getPrdtColor());
    obj.put("prdtCnt", dto.getPrdtCnt());
    obj.put("prdtPrice", dto.getPrdtPrice());
    obj.put("prdtDateIn", dto.getPrdtDateIn());
%>
<%= obj %>