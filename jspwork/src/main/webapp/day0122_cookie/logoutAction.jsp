<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            // 쿠키 이름이 loginOk이고 값이 true일 경우
            if (cookie.getName().equals("loginOk") && cookie.getValue().equals("true")) {
                cookie.setPath("/");
                cookie.setMaxAge(0); // 쿠키 유효시간을 0으로 -> 바로 삭제됨
                response.addCookie(cookie);
                break;
            }
        }
    }
    response.sendRedirect("cookieMain.jsp");
%>
%>