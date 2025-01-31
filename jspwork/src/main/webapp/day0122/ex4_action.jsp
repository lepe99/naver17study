<%@ page import="java.util.Optional" %>
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
    // post 방식 사용시 한글 깨지는 경우 처리
    request.setCharacterEncoding("UTF-8");

    String myId = request.getParameter("myId");
    String myPass = request.getParameter("myPass");
    String myName = request.getParameter("myName");
    String driver = request.getParameter("driver");
    String homeAddr = request.getParameter("homeAddr");

    // checkbox 그룹이 여러개인 경우 -> 배열로 받아옴
    // check를 모두 안했을 경우 null
    String[] hobby = request.getParameterValues("hobby");
    String myFood = request.getParameter("myFood");
    String fColor = request.getParameter("fColor");
    String myBirth = request.getParameter("myBirth");
%>


<body>


<div style="font-size: 20px; color: <%= fColor %>">
    아이디 : <%= myId %><br>
    비밀번호 : <%= myPass %><br>
    이름 : <%= myName %><br>
    <!-- nullPointerException 발생 -->
<%--    운전면허 : <%= driver %> : <%= driver.equals("yes") ? "있음" : "없음" %>    --%>
    <!-- 값이 null이 들어올 수 있을 경우 조건은 null로 설정 -->
    운전면허 : <%= driver %> : <%= driver == null ? "없음" : "있음" %> <br>
    주거지 : <%= homeAddr %><br>

    <!-- #1 -->
    취미 : <%= Optional.ofNullable(hobby).isPresent() ? String.join(", ", hobby) : "없음" %><br>

    <!-- #2 -->
    취미 : <%
    if (hobby == null) {
        out.print("없음");
    } else {
        out.print(String.join(", ", hobby));
    }
    %><br>

    좋아하는 음식 : <img src="../image/food/<%= myFood %>" style="width: 100px; height: 100px; border: 1px;" alt="음식사진"><br>

    글자색 : <%= fColor %><br>
<%--    <script>--%>
<%--        // 글자색 설정--%>
<%--        $("div").css("color", "<%= fColor %>");--%>
<%--    </script>--%>

    생년월일 : <%= myBirth %><br>
</div>
</body>
</html>