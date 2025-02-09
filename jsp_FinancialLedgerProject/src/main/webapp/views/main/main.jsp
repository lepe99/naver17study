<%-- main.jsp --%>
<%@ page import="dto.UsersDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인 페이지</title>
    <link
            href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu
            &family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
            rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <!-- 달력 라이브러리 -->
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js'></script>
    <script src="../../js/main.js"></script>
    <link rel="stylesheet" href="../../css/main.css">
</head>
<%
    UsersDto dto = (UsersDto) session.getAttribute("loginUser");
    int userId;
    if (dto == null) {
        response.sendRedirect("../user/login.html");
    } else {
        userId = dto.getUserId();
    }
%>
<body class="main">
<div class="container" id="infoContainer"></div>
<div class="container" id="calendarContainer"></div>
<div id="transactionModalContainer">
    <jsp:include page="../modal/insertTransactionForm.html"/>
    <jsp:include page="../modal/insertCategoryForm.html"/>
    <jsp:include page="../modal/listDailyTransactionForm.html"/>
</div>
</body>
</html>