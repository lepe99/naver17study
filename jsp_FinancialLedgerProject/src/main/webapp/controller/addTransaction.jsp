<%-- addTransaction.jsp --%>
<%@ page import="dto.UsersDto"%>
<%@ page import="dto.TransactionsDto"%>
<%@ page import="java.sql.Date"%>
<%@ page import="dao.TransactionsDao"%>
<%@ page import="dto.RecurringTransactionsDto"%>
<%@ page import="dao.RecurringTransactionsDao"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    UsersDto usersDto = (UsersDto) session.getAttribute("loginUser");
    int userId = usersDto.getUserId();

    JSONObject json = new JSONObject();
    try{
        String transactionType = request.getParameter("transactionType");
        String description = request.getParameter("description");
        int amount = Integer.parseInt(request.getParameter("amount"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        String transactionFrequency = request.getParameter("transactionFrequency");
        if (transactionFrequency.equals("once")) {
            Date transactionDate = Date.valueOf(request.getParameter("transactionDate"));

            TransactionsDto transactionsDto = new TransactionsDto();
            transactionsDto.setUserId(userId);
            transactionsDto.setTransactionType(transactionType);
            transactionsDto.setDescription(description);
            transactionsDto.setAmount(amount);
            transactionsDto.setCategoryId(categoryId);
            transactionsDto.setTransactionDate(transactionDate);

            TransactionsDao transactionsDao = new TransactionsDao();
            transactionsDao.insertTransaction(transactionsDto);

        } else if (transactionFrequency.equals("recurring")) {
            int intervalValue = Integer.parseInt(request.getParameter("intervalValue"));
            String frequency = request.getParameter("frequency");
            Date startDate = Date.valueOf(request.getParameter("startDate"));
            Date endDate = Date.valueOf(request.getParameter("endDate"));

            RecurringTransactionsDto recurringTransactionsDto = new RecurringTransactionsDto();
            recurringTransactionsDto.setUserId(userId);
            recurringTransactionsDto.setTransactionType(transactionType);
            recurringTransactionsDto.setDescription(description);
            recurringTransactionsDto.setAmount(amount);
            recurringTransactionsDto.setCategoryId(categoryId);
            recurringTransactionsDto.setIntervalValue(intervalValue);
            recurringTransactionsDto.setFrequency(frequency);
            recurringTransactionsDto.setStartDate(startDate);
            recurringTransactionsDto.setEndDate(endDate);

            RecurringTransactionsDao recurringTransactionsDao = new RecurringTransactionsDao();
            recurringTransactionsDao.insertRecurringTransactions(recurringTransactionsDto);
        }
        json.put("success", true);
        json.put("message", "거래를 추가하였습니다.");
    } catch (Exception e) {
        e.printStackTrace();
        json.put("success", false);
        json.put("message", "거래 추가에 실패했습니다.");
    }
    out.print(json.toJSONString());
%>