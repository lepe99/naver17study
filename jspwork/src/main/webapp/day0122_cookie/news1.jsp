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
    </style>
</head>
<%
    boolean isLogin = false;
    // 현재 브라우저에 저장된 모든 쿠키 값 얻기, 없을 경우 null 반환
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            // 쿠키 이름이 loginOk이고 값이 true일 경우
            if (cookie.getName().equals("loginOk") && cookie.getValue().equals("true")) {
                isLogin = true;
                break;
            }
        }
    }
%>
<body>
<% if (isLogin) { // 로그인을 한 상태 %>
<pre>
한국공항공사가 지난 2020년 무안공항의 로컬라이저 개량공사를 발주할 당시 공항공사 사장을 지낸 손창완 전 사장이 숨진채 발견됐다.

21일 경찰에 따르면 손 전 사장은 이날 경기도 자택에서 숨진 것으로 전해졌다. 경찰은 자세한 사망 경위를 조사하고 있다.

손 전 사장은 2020년 5월 무안공항의 방위각시설(로컬라이저) 개량 사업을 할 때 공항공사 사장을 역임했다.

한국공항공사가 2020년 3월 입찰 공고를 내고 장비 안테나 및 철탑, 기초대 등 계기 착륙시설을 설계할 때 ‘부러지기 쉬움’을
고려해 설계해야 한다고 명시했다.

하지만 개량공사를 할 때 안테나 부분은 부러지기 쉽게 했지만 콘크리트 둔덕은 그대로 뒀다. 이 콘크리트 둔덕은 제주항공 참사를
일으킨 주요 원인으로 지목되고 있다.

손 전 사장은 경찰 출신이다. 2011년 경찰대학장을 마친 뒤 경찰에서 은퇴한 뒤 2016년 20대 총선에 나왔으나 낙선했다.
이후 2018년 12월부터 2022년 2월까지 한국공항공사 사장을 지냈다.

김덕준 기자(casiopea@busan.com)
</pre>
<hr>
<jsp:include page="back.jsp"/>
<% } else { %>
<script type="text/javascript">
    alert("로그인이 필요합니다.");
    history.back(); // 이전 페이지로 이동
</script>
<% } %>

</body>
</html>