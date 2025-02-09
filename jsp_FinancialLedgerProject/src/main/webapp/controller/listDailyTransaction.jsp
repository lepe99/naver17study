<%-- listDailyTransaction.jsp --%>
<%@ page import="dto.UsersDto"%>
<%@ page import="java.sql.Date"%>
<%@ page import="dao.TransactionsDao"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    UsersDto userDto = (UsersDto) session.getAttribute("loginUser");
    int userId = userDto.getUserId();

    String dateStr = request.getParameter("date");
    Date date = Date.valueOf(dateStr);

    TransactionsDao transactionsDao = new TransactionsDao();
    Map<Integer, Map<String, Object>> mapList = transactionsDao.getDailyTransactionWithCategory(userId, date);

    JSONObject resultJson = new JSONObject();
    for (Map<String, Object> map : mapList.values()) {
        JSONObject obj = new JSONObject();
        obj.put("id", map.get("id"));
        obj.put("recurringId", map.get("recurringId"));
        obj.put("amount", map.get("amount"));
        obj.put("description", map.get("description"));
        obj.put("transactionType", map.get("transactionType"));
        obj.put("categoryName", map.get("categoryName"));
        resultJson.put(map.get("id").toString(), obj);
    }

    // json 출력
    out.print(resultJson.toJSONString());
%>