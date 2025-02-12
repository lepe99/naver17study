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

        .smallPhoto {
            width: 30px;
            height: 30px;
            border: 1px solid gray;
            margin-right: 5px;
        }

        .box {
            width: 30px;
            height: 30px;
            border: 1px solid gray;
        }

        .tab thead th {
            background-color: #afeeee;
            text-align: center;
        }
    </style>
</head>
<body>
<div style="margin: 20px; width:600px;">
    <h5 class="alert alert-success">
        총 ${totalCount}개의 상품정보가 있습니다

        <button type="button" class="btn btn-sm btn-info" style="float: right;"
                onclick="location.href='./addForm'">상품등록
        </button>
    </h5>

    <table class="tab table table-bordered">
        <caption style="caption-side: top;"><b>전체 상품 목록</b></caption>
        <thead>
        <tr>
            <th style="width: 50px;">번호</th>
            <th style="width: 250px;">상품명</th>
            <th style="width: 80px;">색상</th>
            <th style="width: 120px;">가격</th>
            <th>상세보기</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dto" items="${list}" varStatus="i">
            <tr>
                <td style="text-align: center;">${i.count}</td>
                <td>
                    <img src="${dto.prdtImage}" class="smallPhoto">${dto.prdtName}
                </td>
                <td style="text-align: center;">
                    <div class="box" style="background-color: ${dto.prdtColor}"></div>
                </td>
                <td style="text-align: right;">
                    <fmt:formatNumber value="${dto.prdtPrice}" type="number"/>원
                </td>
                <td style="text-align: center;">
                    <button type="button" class="btn btn-sm btn-success"
                            onclick="location.href='./detail?num=${dto.num}'">상세보기
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>