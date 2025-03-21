<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
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
<body>
<h1>redirect</h1>
<%
    List<String> list = Arrays.asList("red", "green", "blue", "orange");

    // request에 저장
    request.setAttribute("list", list);

    // redirect로 이동한다면? 1. url이 변경된다. 2. request에 저장된 데이터는 사라진다.
    // forward로 이동한다면? 1. url이 변경되지 않는다. 2. request에 저장된 데이터는 유지된다.
    // ex6_redirect2.jsp로 redirect
    response.sendRedirect("ex6_redirect2.jsp");
%>
<h2>list 갯수 : <%= list.size() %></h2>
</body>
</html>