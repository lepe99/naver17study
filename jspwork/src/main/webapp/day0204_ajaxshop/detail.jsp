<%@ page import="shop.data.ShopDao" %>
<%@ page import="shop.data.ShopDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>502 jsp study</title>
    <link
            href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu
            &family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
            rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="main.js"></script>
    <style>
        body * {
            font-family: 'Jua', sans-serif;
        }
    </style>
</head>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    ShopDao dao = new ShopDao();
    ShopDto dto = dao.getData(0, num, null).get(0);
%>
<body>
<div style="margin: 20px;">
    <table>
        <tr>
            <td rowspan="2">
                <img src="<%= dto.getPrdtImg() %>" class="thumbnail img-thumbnail" style="width: 200px; margin-right: 20px;">
            </td>
            <td>
                <span>상품명 : <%= dto.getPrdtName() %></span><br>
                <span>색상 : <%= dto.getPrdtColor() %></span><br>
                <span>수량 : <%= dto.getPrdtCnt() %></span><br>
                <span>가격 : <%= dto.getPrdtPrice() %></span><br>
                <span>입고일 : <%= dto.getPrdtDateIn() %></span>
            </td>
        </tr>
        <tr>
            <td>
                <button class="btn btn-success mod" num="<%= dto.getNum() %>" onclick=openModModal()>수정</button>
                <button class="btn btn-danger" onclick=deletePrdt(<%= dto.getNum() %>)>삭제</button>
                <button class="btn btn-primary" onclick="location.href='main.html'">목록</button>
            </td>
        </tr>
    </table>
</div>
</body>
</html>