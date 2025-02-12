<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
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
<<%
    // 원래는 서블릿에서 받아와야 하는데 일단 여기서 직접 List를 생성해서 출력해보자
    String[] colors = {"green", "red", "orange", "pink", "tomato", "blue"};

    List<String> list = Arrays.asList("K-041", "K-036", "K-045", "K-039", "K-034", "K-054");
%>

<!-- 자바영역의 변수를 JSTL 변수로 변환 -->
<c:set var="colors" value="<%= colors %>"/>
<c:set var="list" value="<%= list %>"/>

<body>
<h3 class="alert alert-danger">JSTL- for 문</h3>
<c:forEach var="myColor" items="${colors}" varStatus="i">
    <h5 style="color:${myColor}">${i.count}(${i.index}) : ${myColor}</h5>
</c:forEach>
<hr>
<c:forEach var="myColor" items="${colors}" varStatus="i" begin="2" end="4">
    <h5 style="color:${myColor}">${i.count}(${i.index}) : ${myColor}</h5>
</c:forEach>
<hr>
<c:forEach var="photo" items="${list}">
    <img src="../image/photo/${photo}.png" width="100" height="100"
         border="1" hspace="5">
</c:forEach>
<hr>
<c:forEach var="carNo" begin="1" end="15" step="1">
    <img src="../image/mycar/mycar${carNo}.png" width="100" height="100">
</c:forEach>
<hr>
<c:set var="msg" value="장미꽃, 국화꽃, 채송화, 다알리아, 프리지아"/>
<!-- 문자열 msg 를 컴마(,) 로 분리하여 출력하기 -->
<c:forTokens var="s" items="${msg}" delims="," varStatus="i">
    <h5>${i.count} : ${s}</h5>
</c:forTokens>

</body>
</html>