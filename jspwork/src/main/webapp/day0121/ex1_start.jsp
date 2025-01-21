<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>title</title>
</head>
<body>
<h3>JSP 주석 확인</h3>
<%--JSP 주석--%>
<!--HTML 주석-->
<script type="text/javascript">
    document.write("Hello");
</script>
<h4>숫자 : <%= num %></h4> <!-- 선언부의 변수는 어디서든 출력 가능 -->
<%! // 선언부
    // 이곳에 변수를 등록하면 서블릿 변환 시 멤버변수로 등록된다
    int num = 10;
%>
<%
    // 스크립트릿 (scriptlet)
    // 이곳에 작성된 코드는 서블릿의 service() 메소드 안으로 들어간다
        // 서블릿의 service() 메소드 안에 작성된 코드는 doGet() 또는 doPost() 메소드 안에 들어간다
    num++;
    out.println("num = " + num);
%>

<h4>숫자 : <%= num %></h4> <!-- 표현식 (expression) 이용한 자바 영역의 변수 출력 -->

<%
    String addr = "서울시 강남구";
    // 자바 영역 안에서 선언된 지역변수는 선언된 곳 보다 아래쪽에서만 사용 가능
%>
<h5 style="color: blue">주소 : <%= addr %></h5>

<%--
jsp 실행 - servlet 변환(java 파일) - class 컴파일 - 브라우저 실행
--%>
</body>
</html>