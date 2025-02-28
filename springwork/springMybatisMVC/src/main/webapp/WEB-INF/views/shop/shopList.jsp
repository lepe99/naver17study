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


        .entityBox figure {
            float: left;
            width: 200px;
            text-align: center;
            background-color: mistyrose;
            border: 1px solid gray;
            border-radius: 20px;
            margin: 10px;
            padding: 10px;
        }

        .entityBox figure img {
            width: 150px;
            height: 170px;
            border: 1px solid gray;
            border-radius: 20px;
            cursor: pointer;
            margin-bottom: 10px;
            object-fit: cover;
        }

        .entityBox figure figcaption {
            text-align: center;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/title.jsp"/>
<div style="margin: 20px; width: 500px;">
    <h5 class="alert alert-danger">
        총 ${totalCount}개의 상품이 있습니다.
        <button type="button" class="btn btn-success btn-sm" style="float: right"
                onclick="location.href='./addForm'">상품추가
        </button>
    </h5>
</div>
<div style="margin: 20px;" class="entityBox">
    <c:forEach var="entity" items="${entityList}" varStatus="i">
        <figure>
            <c:set var="index" value="${i.index}"/>
            <img src="${frontUrl}/shop/${mainImageList.get(index)}${backUrl}" onclick="location.href='./detail?num=${entity.num}'">
            <figcaption>
                <h6>${entity.name}</h6>
                <h6><fmt:formatNumber value="${entity.price}" type="number"/>원</h6>
            </figcaption>
        </figure>
    </c:forEach>
</div>

</body>
</html>