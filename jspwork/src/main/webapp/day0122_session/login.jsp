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
    <%--    <script>--%>
    <%--        window.onload = () => {--%>
    <%--            <%--%>
    <%--                String chkSave = (String) session.getAttribute("chkSave");--%>
    <%--                String myId = (String) session.getAttribute("myId");--%>
    <%--                if (chkSave != null && chkSave.equals("on")) { %>--%>

    <%--            document.getElementById("chkSave").checked = true;--%>
    <%--            document.getElementById("myId").value = "<%= myId %>";--%>
    <%--            <% } %>--%>
    <%--        };--%>
    <%--    </script>--%>
</head>
<body>
<div class="login" style="margin: 30px;">
    <form action="loginAction.jsp" method="post">
        <table class="table table-bordered" style="width: 300px;">
            <tr>
                <td colspan="2" align="center">
                    <label><input type="checkbox" name="chkSave" id="chkSave"> 아이디 저장</label>
                </td>
            </tr>
            <tr>
                <th style="width: 100px;" class="table-info">아이디</th>
                <td>
                    <input type="text" name="myId" class="form-control" id="myId" placeholder="아이디" autofocus required>
                </td>
            </tr>
            <tr>
                <th style="width: 100px;" class="table-info">비밀번호</th>
                <td>
                    <input type="password" name="myPwd" class="form-control" placeholder="비밀번호" required>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="table-danger" align="center">
                    <button type="submit" name="btnLogin" class="btn btn-default"
                            style="width: 150px;">회원 로그인
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>
<%
    String chkSave = (String) session.getAttribute("chkSave");
    String myId = (String) session.getAttribute("myId");
    if (chkSave != null && chkSave.equals("on")) { %>
<script>
    document.getElementById("chkSave").checked = true;
    document.getElementById("myId").value = "<%= myId %>";
    // 태그 내에 직접 vaule 주는 방법도 있음
</script>
<% } %>

</body>
</html>