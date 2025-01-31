<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String pwd = request.getParameter("pwd");
    // 암호가 bitcamp인 경우 쿠키 생성 (이름: loginOk, 값: true)
    if (pwd.equals("bitcamp")) {
        Cookie cookie = new Cookie("loginOk", "true"); // 쿠키의 key, value
        cookie.setPath("/"); // 쿠키의 유효 경로 설정
        cookie.setMaxAge(60 * 60); // 쿠키의 유효 시간 설정 (s)
        response.addCookie(cookie); // 쿠키를 클라이언트에게 전송
        response.sendRedirect("cookieMain.jsp"); // 메인 페이지로 이동
    } else { %>
<script>
    alert("비밀번호가 일치하지 않습니다.");
    history.back(); // 이전 페이지로 이동
</script>
<% } %>