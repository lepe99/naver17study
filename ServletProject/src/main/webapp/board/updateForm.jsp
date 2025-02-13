<%@ page import="reboard.data.BoardDto" %>
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

        .tab1 tbody th {
            background-color: #fff0f5;
        }
    </style>
    <script>
        $(document).ready(function () {
            if (localStorage.loginOk == null) {
                $(".noLogin").show();
                $(".okLogin").hide();
            } else {
                $(".noLogin").hide();
                $(".okLogin").show();
            }
        });

    </script>
</head>
<body>
<jsp:include page="../kakao/kakaoLogin.jsp"/>
<br><br>
<hr>
<div style="margin: 20px; width: 500px; text-align: center;" class="noLogin">
    <h2>글을 수정하려면 먼저 로그인을 해주세요.</h2>
</div>
<div style="margin: 20px; width: 500px;" class="okLogin">
    <form action="./update" method="post">
        <!-- hidden -->
        <input type="hidden" name="num" value="${num}">
        <input type="hidden" name="pageNum" value="${pageNum}">

        <table class="table table-bordered tab1">
            <caption style="caption-side: top;">
                <b>수정하기</b>
            </caption>
            <tr>
                <th>제 목</th>
                <td>
                    <input type="text" name="subject" class="form-control" value="${subject}" required>
                </td>
            </tr>
            <tr>
                <th>내 용</th>
                <td>
                    <!-- textarea 태그는 rows 속성을 사용하여 여러 줄의 텍스트를 입력할 수 있는 입력란을 만듭니다. -->
                    <textarea name="content" class="form-control"
                              style="width: 100%; height: 120px;" required>${content}</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <button type="submit" class="btn btn-outline-secondary btn-sm">저장하기</button>
                    <button type="button" class="btn btn-outline-secondary btn-sm"
                            onclick="history.back()">이전으로</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>