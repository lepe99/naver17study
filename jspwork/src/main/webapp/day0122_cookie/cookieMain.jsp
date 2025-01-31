<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>502 jsp study</title>
    <link
            href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
            rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <style>
        body * {
            font-family: 'Jua', sans-serif;
        }
    </style>
</head>
<%
    boolean isLogin = false;
    // 현재 브라우저에 저장된 모든 쿠키 값 얻기, 없을 경우 null 반환
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            // 쿠키 이름이 loginOk이고 값이 true일 경우
            if (cookie.getName().equals("loginOk") && cookie.getValue().equals("true")) {
                isLogin = true;
                break;
            }
        }
    }
%>
<body>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<h2><%= sdf.format(new Date()) %> : 오늘의 기사 모음</h2>
<hr>
<% if (isLogin) { %>
<jsp:include page="cookieLogout.jsp"/>
<% } else { %>
<jsp:include page="cookieLogin.jsp"/>
<% } %>
<hr>
<h3 class="alert alert-danger">오늘의 주요 뉴스</h3>
<jsp:include page="paper.jsp"/>
</body>
</html>