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
도널드 트럼프 미국 대통령이 지난 21일(현지시간) '국가기도회'(A Service of Prayer for the Nation)에 참석했습니다.

트럼프 대통령은 이날 오전 워싱턴DC의 워싱턴국립대성당에서 열린 기도회에 부인 멜라니아 여사와 함께 자리했습니다.

이 기도회는 1933년에 시작된 전통적인 미국 대통령 취임 행사로, 이날 기도회는 종교 초월 행사로 진행됐습니다.

설교를 맡은 마리앤 버드 성공회 워싱턴 교구 주교는 트럼프 대통령을 향해 "대통령님, 마지막으로 한 가지 부탁을 드리겠다"며
"지금 두려움에 떨고 있는 이 나라의 국민들에게 자비를 베풀어 달라"고 말했습니다.

버드 주교는 "민주당, 공화당, 무소속 가정에 게이, 레즈비언, 트랜스젠더 자녀들이 있으며 이들 중 일부는
생명의 위협을 느끼고 있다"면서"적절한 서류를 갖추지 못했을 수도 있지만 대부분의 이민자는 범죄자가 아니다"라고
성소수자의 권리를 존중하고 이민자를 보호해달라고 호소했습니다.

또, "부모를 잃을까 봐 두려워하는 아이들과 전쟁, 박해를 피해 피난처를 구하려는 이들에게 연민과 환대를 허락해달라"며
"우리 모두 한때는 이 땅에서 이방인이었다"고 덧붙였습니다.

트럼프 대통령은 백악관으로 돌아가는 길에 만난 기자들에게 "(기도회가) 흥미롭지 않다"고 밝혔습니다.

그러면서 "좋은 기도회였다고 생각하지 않는다"고 말했습니다.

트럼프의 강력한 지지자인 일론 머스크도 자신의 SNS에 "그녀는 깨어 있는(진보적) 정신 바이러스에 심하게 걸렸다"며 버드 주교를
비판하는 글을 올렸습니다.

■ 제보하기
▷ 전화 : 02-781-1234, 4444
▷ 이메일 : kbs1234@kbs.co.kr
▷ 카카오톡 : 'KBS제보' 검색, 채널 추가
▷ 네이버, 유튜브에서 KBS뉴스를 구독해주세요!



서다은 (standeun@kbs.co.kr)
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