<%-- deleteTransaction.jsp --%>
<%@ page import="dao.TransactionsDao"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="dao.RecurringTransactionsDao"%>
%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    int recurringId = Integer.parseInt(request.getParameter("recurringId"));

    JSONObject json = new JSONObject();
    try{
        if (recurringId == 1) {
            TransactionsDao transactionsDao = new TransactionsDao();
            transactionsDao.deleteTransaction(id);
            json.put("success", true);
            json.put("message", "거래내역을 삭제하였습니다.");
        } else {
            RecurringTransactionsDao recurringTransactionsDao = new RecurringTransactionsDao();
            recurringTransactionsDao.deleteRecurringTransactions(recurringId);
            json.put("success", true);
            json.put("message", "거래내역을 삭제하였습니다.");
        }
    } catch (Exception e) {
        json.put("success", false);
        json.put("message", "거래내역 삭제에 실패했습니다.");
    }
    out.print(json.toJSONString());
%>
