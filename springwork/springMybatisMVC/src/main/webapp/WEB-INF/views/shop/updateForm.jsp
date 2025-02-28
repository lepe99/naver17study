<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
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
    <style>
        body * {
            font-family: 'Jua', sans-serif;
        }

        .tab1 tbody th {
            background-color: cornflowerblue;
        }
    </style>
</head>
<body>
<div style="margin: 30px; width: 500px;">
    <form action="update" method="post" enctype="multipart/form-data">
        <input type="hidden" name="num" value="${entity.num}">
        <input type="hidden" name="oldImages" value="${entity.image}">
        <table class="table table-bordered tab1">
            <caption style="caption-side: top;"><b>상품 수정</b></caption>
            <tbody>
            <tr>
                <th style="width: 100px;">상품명</th>
                <td><input type="text" name="name" autofocus required class="form-control" value="${entity.name}"></td>
            </tr>
            <tr>
                <th>가격</th>
                <td><input type="number" name="price" required class="form-control" step="5000" value="${entity.price}"></td>
            </tr>
            <tr>
                <th>수량</th>
                <td><input type="number" name="qty" required class="form-control" value="${entity.qty}"></td>
            </tr>
            <tr>
                <th>색상</th>
                <td><input type="color" name="color" class="form-control" value="${entity.color}"></td>
            </tr>
            <tr>
                <th>입고일</th>
                <td><input type="date" name="arrivalDate" class="form-control" value="${entity.arrivalDate}"></td>
            </tr>
            <tr>
                <th>사진</th>
                <td><input type="file" name="images" class="form-control" multiple></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <button type="submit" class="btn btn-success btn-sm">상품수정</button>
                    <button type="button" class="btn btn-success btn-sm" onclick="history.back()">이전으로</button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>