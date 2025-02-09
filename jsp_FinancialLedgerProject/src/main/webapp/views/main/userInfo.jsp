<%-- userInfo.jsp --%>
<%@ page import="dto.UsersDto" %>
<%@ page import="dao.UserBalancesDao" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="dao.TransactionsDao" %>
<%@ page import="dto.UserBalancesDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    UsersDto userDto = (UsersDto) session.getAttribute("loginUser");
    int userId = userDto.getUserId();
    String userName = userDto.getUsername();

    int year = (int) session.getAttribute("year");
    int month = (int) session.getAttribute("month");



    TransactionsDao transactionsDao = new TransactionsDao();
    int incomeSum = transactionsDao.getIncomeSum(userId);
    int expenseSum = transactionsDao.getExpenseSum(userId);
    int totalSum = incomeSum + expenseSum;

    UserBalancesDao userBalancesDao = new UserBalancesDao();
    int initBalance = userBalancesDao.getInitBalance(userId);
    UserBalancesDto userBalancesDto = new UserBalancesDto();
    userBalancesDto.setUserId(userId);
    userBalancesDto.setInitBalance(initBalance);
    userBalancesDao.updateCurrentBalance(userBalancesDto, totalSum);
    int currentBalance = userBalancesDao.getUserBalance(userId);

    int incomeSumByMonth = transactionsDao.getIncomeSumByMonth(userId, year, month);
    int expenseSumByMonth = transactionsDao.getExpenseSumByMonth(userId, year, month);
    int totalSumByMonth = incomeSumByMonth + expenseSumByMonth;

    int incomeSumExpected = incomeSum + transactionsDao.getIncomeSumExpected(userId, year, month);
    int expenseSumExpected = expenseSum + transactionsDao.getExpenseSumExpected(userId, year, month);
    int totalSumExpected = incomeSumExpected + expenseSumExpected;
    int expectedBalance = initBalance + totalSumExpected;
%>
<script src="../../js/userInfo.js"></script>
<link rel="stylesheet" href="../../css/userInfo.css">
<div>
    <span class="userName"><%= userName %>의</span>
    <button id="btnLogout" class="btn btn-danger btn-sm">로그아웃</button>
</div>
<div>
    <table>
        <thead>
        <tr>
            <th>현재 잔고</th>
            <td class="userName"><span class="amount"><%= String.format("%,d", currentBalance)%> 원</span></td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>총 수입</td>
            <td><span class="amount income"><%= String.format("%,d", incomeSum)%> 원</span></td>
        </tr>
        <tr>
            <td>총 지출</td>
            <td><span class="amount expense"><%= String.format("%,d", expenseSum)%> 원</span></td>
        </tr>
        <tr>
            <td>합계</td>
            <td><span class="amount"><%= String.format("%,d", totalSum)%> 원</span></td>
        </tr>
        </tbody>
    </table>
</div>
<hr>
<div>
    <table>
        <thead>
        <tr>
            <th colspan="2"><%= year %>년 <%= month %>월의</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>수입</td>
            <td><span class="amount income"><%= String.format("%,d", incomeSumByMonth)%> 원</span></td>
        </tr>
        <tr>
            <td>지출</td>
            <td><span class="amount expense"><%= String.format("%,d", expenseSumByMonth)%> 원</span></td>
        </tr>
        <tr>
            <td>합계</td>
            <td><span class="amount"><%= String.format("%,d", totalSumByMonth)%> 원</span></td>
        </tr>
        </tbody>
    </table>

</div>
<hr>
<div>
    <%
        LocalDate selectedDate = LocalDate.of(year, month, 1).plusMonths(1);
        LocalDate today = LocalDate.now();

        if (today.isBefore(selectedDate)) { %>
    <table class="table3">
        <thead>
        <tr>
            <th colspan="2"><%= year %>년 <%= month %>월 까지의</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>예상 수입</td>
            <td><span class="amount income"><%= String.format("%,d", incomeSumExpected)%> 원</span></td>
        </tr>
        <tr>
            <td>예상 지출</td>
            <td><span class="amount expense"><%= String.format("%,d", expenseSumExpected)%> 원</span></td>
        </tr>
        <tr>
            <td>합계</td>
            <td><span class="amount"><%= String.format("%,d", totalSumExpected)%> 원</span></td>
        </tr>
        <tr>
            <td>예상 잔고</td>
            <td><span class="amount"><%= String.format("%,d", expectedBalance)%> 원</span></td>
        </tr>
        </tbody>
    </table>
    <% } else { %>
    <div class="table3 altTable">현재 날짜보다 이전의 월 조회 시 <br>표시되지 않습니다.</div>
    <% } %>
</div>
<hr>
<div>
    <button id="btnAddTransaction" class="btn btn-primary">수입/지출 추가</button>
    <button id="btnCategoryManagement" class="btn btn-primary">카테고리 관리</button>
</div>