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

        .formTable tbody th {
            background-color: orange;
        }
    </style>
</head>
<body>
<!-- 로그인 하지 않을 경우 이전 페이지로 이동 -->
<c:if test="${empty sessionScope.loginOk}">
    <script>
        alert("로그인이 필요합니다.");
        history.back();
    </script>
</c:if>
<jsp:include page="../layout/title.jsp"/>
<div style="margin: 20px; width: 600px;">
    <form action="insert" method="post" enctype="multipart/form-data">
        <input type="hidden" name="idx" value="${idx}">
        <input type="hidden" name="regroup" value="${regroup}">
        <input type="hidden" name="restep" value="${restep}">
        <input type="hidden" name="relevel" value="${relevel}">
        <input type="hidden" name="pageNum" value="${pageNum}">

        <table class="table table-bordered formTable">
            <caption style="caption-side: top;">
                <h5>${idx == 0 ? "새글쓰기" : "답글쓰기"}</h5>
            </caption>
            <tbody>
            <tr>
                <th style="width: 100px;">제 목</th>
                <td>
                    <input type="text" name="subject" class="form-control" required autofocus>
                </td>
            </tr>
            <tr>
                <th>사 진</th>
                <td>
                    <input type="file" name="upload" class="form-control" multiple>
                </td>
            </tr>
            <tr>
                <th>내 용</th>
                <td>
                    <textarea name="content" class="form-control" required style="width: 100%; height: 150px;"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: right;">
                    <button type="submit" class="btn btn-outline-secondary">저장</button>
                    <button type="button" class="btn btn-outline-secondary" onclick="history.back()">취소</button>
                </td>
            </tr>
            </tbody>

        </table>
    </form>
</div>
</body>
</html>