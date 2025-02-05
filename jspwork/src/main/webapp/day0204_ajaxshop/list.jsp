<%@ page import="shop.data.ShopDto" %>
<%@ page import="java.util.List" %>
<%@ page import="shop.data.ShopDao" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.Optional" %>
<%@ page language="java" contentType="text/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String search = request.getParameter("search");
    int order = Optional.ofNullable(request.getParameter("order")).map(Integer::parseInt).orElse(1);

    ShopDao dao = new ShopDao();
    List<ShopDto> list = dao.getData(order, 0, search);

    JSONArray arr = new JSONArray();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    for (ShopDto dto : list) {
        JSONObject obj = new JSONObject();
        obj.put("num", dto.getNum());
        obj.put("prdtName", dto.getPrdtName());
        obj.put("prdtColor", dto.getPrdtColor());
        obj.put("prdtCnt", dto.getPrdtCnt());
        obj.put("prdtPrice", dto.getPrdtPrice());
        obj.put("prdtImg", dto.getPrdtImg());
        obj.put("prdtDateIn", dto.getPrdtDateIn());
        arr.add(obj);
    }
%>
<%= arr %>