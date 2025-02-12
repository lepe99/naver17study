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

        .tab1 thead th {
            background-color: #fff0f5;
        }
    </style>
</head>
<body>
<jsp:include page="../kakao/kakaoLogin.jsp"/>
<br><br>
<hr>
<div style="margin: 20px; width: 600px;">
    <table class="table table-bordered tab1">
        <caption style="caption-side: top;">
            <b>총 ${totalCount}개의 글이 있습니다.</b>
            <button type="button" class="btn btn-outline-secondary" style="float: right;"
                    onclick="location.href='./writeForm'">글쓰기</button>
        </caption>
        <thead>
        <tr>
            <th style="width: 50px;">번호</th>
            <th style="width: 300px;">제목</th>
            <th style="width: 100px;">작성자</th>
            <th style="width: 100px;">작성일</th>
            <th>조회</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${totalCount == 0}">
            <tr style="height: 50px;">
                <td colspan="5" style="text-align: center; vertical-align: middle;">
                    <b>등록된 게시글이 없습니다.</b>
                </td>
            </tr>
        </c:if>
        <c:if test="${totalCount > 0}">
            <c:forEach var="dto" items="${list}" varStatus="i">
                <tr>
                    <td style="text-align: center;">${totalCount - i.index}</td>
                    <td><!-- 제목 -->
                        <a style="cursor: pointer; text-decoration: none; color: black;"
                           href="./detail?num=${dto.num}">
                            <!-- level 1 당 3칸정도 띄우기 -->
                            <c:forEach begin="1" end="${dto.relevel * 2}">
                                &nbsp;
                            </c:forEach>
                            <!-- 답글 인 경우 reply 이미지 넣기 -->
                            <c:if test="${dto.relevel > 0}">
                                <img src="../image/re.png">
                            </c:if>
                            <span>${dto.subject}</span>
                        </a>
                    </td>
                    <td style="text-align: center;">${dto.writer}</td>
                    <td style="text-align: center; font-size: 0.9em;">
                        <fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td style="text-align: center;">${dto.readcount}</td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</body>
</html>