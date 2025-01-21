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

        .tab th {
            background-color: orange;
        }
    </style>
</head>
<body>
<h5 class="alert alert-danger">자바영역의 배열 출력하기</h5>
<%
    // 자바 영역
    String[] arr = {"red", "green", "blue", "yellow", "pink", "purple"};
%>
<table class="table table-bordered tab" style="width: 200px;">
    <caption align="top"><b>배열 출력</b></caption>
    <tr>
        <th width="100">인덱스</th>
        <th width="100">색상</th>
    </tr>
    <%
        for (int i = 0; i < arr.length; i++) {
    %>
    <tr>
        <td align="center"><%= i + 1 %></td>
        <td style="color: <%= arr[i] %>"><%= arr[i] %></td>
    </tr>
    <% } %>
</table>
<hr>
<table class="table table-striped tab" style="width: 200px;">
    <tr>
        <th>번호</th><th>색상</th>
    </tr>
    <%
        int n = 0;
        for (String s : arr) {
    %>
    <tr>
        <td align="center"><%= ++n %></td>
        <td style="background-color: <%= s %>"><%= s %></td>
    </tr>
    <% } %>
</table>
</body>
</html>