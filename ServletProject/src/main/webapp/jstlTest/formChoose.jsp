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
        body *{
            font-family: 'Jua';
        }

        .country1{
            background-color: yellow;
            color: blue;
        }
        .country2{
            background-color: pink;
            color: gray;
        }
        .country3{
            background-color:black;
            color: yellow;
        }

        .noCountry{
            background-color: cyan;
            color: red;
        }
    </style>
</head>
<body>
<div style="margin: 20px;">
    <form action="formChoose.jsp" method="post">
        이름입력 : <input type="text" name="myName"><br>
        가고싶은 나라입력 : <input type="text" name="myCountry"><br>
        <button type="submit">결과 확인</button>
    </form>

    <!-- JSTL 로 폼태그에 입력한 값을 바로 읽어오기 -->

    <c:if test="${!empty param.myName and !empty param.myCountry}">
        <div style="margin: 20px;">
            <h5>이름 : ${param.myName}</h5>
            <h5>가고싶은 나라 : ${param.myCountry}</h5>
            <hr>
            <c:set var="country" value="${param.myCountry}"/>

            <c:choose>
                <c:when test="${country == '프랑스'}">
                    <h2 class="country1">프랑스는 에펠탑이 아름답습니다</h2>
                </c:when>
                <c:when test="${country == '미국'}">
                    <h2 class="country2">미국은 자유의 여신상이 아름답습니다</h2>
                </c:when>
                <c:when test="${country == '스위스'}">
                    <h2 class="country3">스위스는 자연풍경이 아름답습니다</h2>
                </c:when>
                <c:otherwise>
                    <h2 class="noCountry">${country} 은(는) 무엇이 아름다울까요?</h2>
                </c:otherwise>
            </c:choose>
        </div>
    </c:if>

    <!-- 이름과 나라명 중 하나라도 값이 없을경우 h2 태그로
    "두 데이터를 모두 입력해주세요" 라고 출력 -->
    <c:if test="${empty param.myName or empty param.myCountry}">
        <h2>두 데이터를 모두 입력해주세요</h2>
    </c:if>
</div>
</body>
</html>