<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String chkSave = request.getParameter("chkSave"); // on or null
    String myId = request.getParameter("myId");
    String myPwd = request.getParameter("myPwd");

    if (myId.equals("angel") && myPwd.equals("1234")) {
        if (chkSave != null) {
            session.setAttribute("myId", myId);
            session.setAttribute("chkSave", "on");
        } else {
            // 이전에 저장된 세션 삭제
            session.removeAttribute("myId");
            session.removeAttribute("chkSave");
        }
        session.setAttribute("isLogin", "true");

        // 유지시간 지정 (생략 시 기본 30분)
        session.setMaxInactiveInterval(60 * 60); // 1시간 (s)

        response.sendRedirect("main.jsp"); // 메인 페이지 이동
    } else { %>
<script>
    alert("아이디와 비밀번호가 맞지 않습니다");
    history.back();
</script>
<% } %>