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
    </style>
</head>
<body>
<h2>TestServletEx1 으로부터 포워드</h2>
<!-- request 영역의 변수를 requestScope 로 가져온다 (생략 가능) -->
<h3>오늘 날짜 : ${requestScope.today}</h3>
<h3>오늘 날짜 : ${today}</h3>
<h3>오늘 날짜 : ${today2}</h3>
<h3>이름 : ${myName}</h3>
<h3>나이 : ${myAge}</h3>
<hr>
<!-- jstl 로 변수선언와 연산자 공부하기 -->
<c:set var="num1" value="7"/>
<c:set var="num2" value="4"/>

<h5>숫자 1 : ${num1}</h5>
<h5>숫자 2 : ${num2}</h5>
<h6>더하기 : ${num1 + num2}</h6>
<h6>빼기 : ${num1 - num2}</h6>
<h6>곱하기 : ${num1 * num2}</h6>
<h6>나누기 1 : ${num1 / num2}</h6>
<h6>나누기 2 : ${num1 div num2}</h6>
<h6>나머지 1 : ${num1 % num2}</h6>
<h6>나머지 2 : ${num1 mod num2 }</h6>

<!--  jstl 에는 증감연산자가 없다. 그러면 num1 에 1을 더해서 출력하려면 -->
<c:set var="num1" value="${num1 + 1}"/>
<h6>num1을 1 증가: ${num1}</h6>

<!-- 나이에 따라 성인인지 미성년자인지 출력 해 보자 -->
<c:if test="${myage >= 30}">
    <h2 style="color:blue;">${myname}님은 성인입니다</h2>
</c:if>
<c:if test="${myage < 30}">
    <h2 style="color: red;">${myname}님은 미성년자입니다</h2>
</c:if>
</body>
</html>