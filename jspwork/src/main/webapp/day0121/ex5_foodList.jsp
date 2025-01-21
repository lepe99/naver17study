<%@ page import="test.day0121.FoodDataList" %>
<%@ page import="java.util.List" %>
<%@ page import="test.data.FoodDto" %>
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
            background-color: pink;
        }
    </style>
</head>
<%
    // FoodDataList 생성
    FoodDataList dataList = new FoodDataList();
    List<FoodDto> list = dataList.getAllData();
%>
<body>
<div style="margin: 20px;">
    <table class="table table-bordered tab" style="width: 600px;">
        <caption align="top">
            <h3><b>배달음식 목록</b></h3>
        </caption>
        <tr>
            <th width="50">번호</th>
            <th width="200">메뉴</th>
            <th width="60">수량</th>
            <th width="100">가격</th>
            <th>주문일</th>
        </tr>
        <%
            int no = 0;
            for(FoodDto dto : list) {
        %>
        <tr>
            <td align="center"><%= ++no %></td>
            <td>
                <img src="../image/food/<%= dto.getFoodPhoto() %>" style="width: 50px; height: 50px; border: 1px"
                    class="rounded-circle" hspace="10">
                <b><%= dto.getFoodName() %></b>
            </td>
            <td align="right"><%= dto.getFoodCnt() %>개</td>
            <td align="right"><%= dto.getFoodPrice() %>원</td>
            <td><%= dto.getFoodDay() %></td>
        <% } %>
    </table>
</div>
</body>
</html>