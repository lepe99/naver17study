<%-- getMonthlyTransactions.jsp --%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.List"%>
<%@ page import="dto.TransactionsDto"%>
<%@ page import="dao.TransactionsDao"%>
<%@ page import="dto.UsersDto"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    UsersDto usersDto = (UsersDto) session.getAttribute("loginUser");
    int userId = usersDto.getUserId();

    int year = Integer.parseInt(request.getParameter("year"));
    int month = Integer.parseInt(request.getParameter("month"));

    session.setAttribute("year", year);
    session.setAttribute("month", month);

    TransactionsDao transactionsDao = new TransactionsDao();
    // 해당 월의 거래내역
    List<TransactionsDto> transactionsDto = transactionsDao.getMonthlyTransactions(userId, year, month);

    // 날짜 별 수입, 지출, 합계 가져오기
    Map<LocalDate, Map<String, Integer>> dailySummary = new HashMap<>();
    for (TransactionsDto dto : transactionsDto) {
        LocalDate transactionDate = dto.getTransactionDate().toLocalDate();

        // 해당 날짜에 대한 항목이 없다면 map 초기화
        dailySummary.computeIfAbsent(transactionDate, k -> new HashMap<>());

        // 해당 날짜의 map 가져오기
        Map<String, Integer> summary = dailySummary.get(transactionDate);

        int amount = dto.getAmount();
        // amount가 양수면 수입, 음수면 지출
        if (amount > 0) {
            summary.put("income", summary.getOrDefault("income", 0) + amount);
        } else {
            summary.put("expense", summary.getOrDefault("expense", 0) + amount);
        }
        summary.put("total", summary.getOrDefault("total", 0) + amount);
    }

    // LocalDate를 String으로 변환하기 위한 formatter 생성
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // dailySummary를 JSON으로 변환
    JSONObject resultJson = new JSONObject();
    // 키, 값 쌍으로 변환
    for (Map.Entry<LocalDate, Map<String, Integer>> entry : dailySummary.entrySet()) {
        LocalDate date = entry.getKey();
        Map<String, Integer> summary = entry.getValue();

        // 날짜를 문자열로 변환
        String dateString = date.format(formatter);

        // summary를 JSON으로 변환
        JSONObject summaryJson = new JSONObject();
        summaryJson.put("income", summary.getOrDefault("income", 0));
        summaryJson.put("expense", summary.getOrDefault("expense", 0));
        summaryJson.put("total", summary.getOrDefault("total", 0));

        resultJson.put(dateString, summaryJson);
    }

    // JSON 출력
    out.print(resultJson.toJSONString());
%>