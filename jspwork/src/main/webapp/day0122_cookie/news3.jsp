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
한국사 일타 강사로 불리는 전한길씨가 윤석열 대통령이 비상계엄 선포 이유로 꼽은 부정선거 의혹에 동조하자, 전씨를 비판하는 제자들의 성토가 이어지고 있다.

지난 21일 전씨가 운영하는 네이버 카페 '전한길한국사'에는 전씨의 주장에 대한 제자들의 반박과 우려가 담긴 게시물이 다수 올라왔다. 부정선거 의혹을 제기하며 윤 대통령의 비상계엄 선포가 불가피했다고 주장한 전씨를 비판하는 내용이었다.

먼저 2017년 전씨 강의를 수강, 현재 선거관리위원회에서 근무하고 있다는 A씨는 "당시 선생님의 말씀을 들으며 정말 많은 것을 배웠다고 생각했는데, 지금 선생님께서 하시는 말씀을 보니 제가 잘못 기억하고 있던 건 아닌가 하는 생각이 든다"고 했다.

A씨는 "선거일에 시간이 되신다면 가까운 투표소나 개표소에 들러주셨으면 한다. 새벽부터 그다음 날 새벽이 되도록 묵묵히 일하며 공정한 선거를 위해 헌신하는 사람들이 있다"며 "그들의 모습을 직접 확인해 주신다면, 지금의 주장에 대해 다시 한번 생각해 볼 기회가 되지 않을까 싶다"고 했다.

5년 차 지방직 공무원이라는 B씨는 "선생님이 어쩌다 이런 사고를 갖게 되신 건지 정말 보고도 믿을 수가 없다"며 "이런 발언은 선생님을 존경하는 수많은 지방직 공무원들을 호도하는 것"이라고 했다.

B씨는 "저희는 근무하면서 한 표라도 잘못되면 어떡하나 하는 심정으로 하루 일당 10만원 받으면서 12시간 혹은 14시간 동안 근무한다"며 "투표가 끝나고 투표함을 지정된 장소로 옮기는 과정에서 전부 현직 공무원들이 책임감을 갖고 임무를 수행하고, 그 과정에서 각 정당의 참관인들이 모두 참여하게 돼 있다. 그분들은 수상한 게 하나만 나와도 따져 묻는다"고 했다.

전국 단위 선거마다 개표 사무원을 하고 있다는 C씨도 전씨가 '수개표 제도 도입'을 주장한 데 대해 "우리나라도 수개표를 한다. 전자분류기로 분류할 뿐, 손으로 수를 센다. 여러 정당을 지지하는 수많은 참관인이 눈에 불을 켜고 조작이 있는지 개표 내내 감시한다"고 했다.

그러면서 "묵묵히 일하는 제자들 팔지 말고, 욕 먹이지 말라. 당신이 생각하는 것처럼 무식하지 않다. 선동당한 게 본인이라는 의심은 없냐"고 덧붙였다.

제자들의 성토가 이어지자 전씨는 "글 제대로 읽지도 않고 악의적인 댓글 다는 분들로 인해 어쩔 수 없이 제한하겠다. 계엄 찬성과 반대에 관한 것, 그 뒤로 일어난 언론, 선관위, 사법부 등에 대한 의견은 이미 유튜브로 올렸으니 거기 가서 얼마든지 댓글 달아주시고, 이 카페는 공무원 한국사 카페이니 양해 바란다"는 공지를 올렸다.

앞서 전씨는 지난 20일 자신의 유튜브 채널에 '대한민국 혼란 선관위가 초래했다'라는 제목의 영상을 올려 "비상계엄과 탄핵 정국 속에서 제가 왜 이렇게 나서서 영상을 제작하겠냐"며 "이미 대한민국 언론은 현 사태에 대한 공정한 보도는 무너졌고, 특정 이념과 정당에 편파적인 보도로 인해 국민들을 가스라이팅 시키고 있다"고 영상을 올린 이유를 밝혔다.

전씨는 "비상계엄 선포 때 알려진 바로는 계엄군이 국회에 280명이 투입됐고, 선관위에는 국회보다 더 많은 297명이나 투입됐다고 해서 모두가 어리둥절했다"며 "비상계엄을 선포한 대통령 당사자가 선거에 떨어진 것도 아니고 당선된 대통령으로서 조사해서 더 이득 볼 것도 없지 않나. '왜'라는 생각이 들었고, 공무원 강사로서 선관위에서 근무하고 있는 수많은 제자 생각도 나고 해서 많은 자료를 찾아보았는데, 경악을 금치 못했다"고 했다.

그러면서 "국민들이 내는 세금으로 운영되는 국가기관이자 공무원인데, 감사원의 감사에도 반발하고, 북한의 사이버 테러와 해킹 의혹을 조사하고자 하는 국정원의 조사마저도 거부하고 선관위가 이렇게 절대 권력기관이라는 것에 놀랐다"며 "대통령뿐만 아니라 현 야당 대표 및 야당 국회의원, 전 여당 대표 및 여당 국회의원까지도 부정선거 의혹을 제기하고 있는, 그야말로 총체적인 비리와 의혹 덩어리라는 것을 알게 됐다"고 강조했다.

또 "대만처럼 수작업 투표, 투표함 이동 없이 수개표를 통해 가장 투명하고 가장 공정하게 선거제도가 되길 소망한다"고도 했다. 하지만 선관위는 해킹 및 투·개표 시스템 조작 가능성 주장과 관련, 현실적으로 불가능하다고 일축했다. 선관위는 "우리나라의 투·개표는 '실물 투표'와 '공개 수작업 개표' 방식으로 진행되며, 정보시스템 및 기계장치는 이를 보조하는 수단에 불과하다"고 했다.

홍민성 한경닷컴 기자 mshong@hankyung.com
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