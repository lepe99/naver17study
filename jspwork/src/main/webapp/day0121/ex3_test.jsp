<%@ page import="test.data.ShopDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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

        .tab thead th {
            background-color: olive;
        }

        .tab tbody td {
            background-color: lightgray;
        }
    </style>
</head>
<%!
    List<ShopDto> list = new ArrayList<>();
%>
<%
    list.add(new ShopDto("사과", 3, 2000));
    list.add(new ShopDto("바나나", 1, 1000));
    list.add(new ShopDto("오렌지", 5, 3000));
    list.add(new ShopDto("딸기", 2, 4000));
    list.add(new ShopDto("참외", 6, 6000));
%>
<body>
<table class="table table-bordered tab" style="width: 500px;">
    <thead>
    <th style="width: 50px">번호</th>
    <th style="width: 100px">과일명</th>
    <th style="width: 50px">수량</th>
    <th style="width: 100px">단가</th>
    <th>총액</th>
    </thead>
    <tbody>
    <%
        int no = 1;
        for(ShopDto dto : list) {
    %>
    <tr>
        <td align="center"><%= no++ %></td>
        <td><%= dto.getName() %></td>
        <td align="right"><%= dto.getCnt() %></td>
        <td align="right"><%= dto.getPrice() %></td>
        <td align="right"><%= dto.getCnt() * dto.getPrice() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>