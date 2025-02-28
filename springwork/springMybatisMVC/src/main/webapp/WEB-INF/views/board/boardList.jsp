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

        .boardTable thead th {
            text-align: center;
            background-color: #ccc;
        }

        .boardTable i.bi {
            color: #777;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/title.jsp"/>
<div style="margin: 20px; width: 700px;">
    <h5 class="alert alert-danger">
        총 ${totalCount}개의 게시글이 있습니다.

        <button type="button" class="btn btn-success btn-sm" style="float: right;" onclick="location.href='writeForm'">
            <i class="bi bi-pencil-square"></i> 글쓰기
        </button>
    </h5>
    <table class="table table-bordered boardTable">
        <thead>
        <tr>
            <th style="width: 50px;">번호</th>
            <th style="width: 380px;">제목</th>
            <th style="width: 80px;">작성자</th>
            <th style="width: 120px;">작성일</th>
            <th>조회수</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${totalCount == 0}">
            <tr>
                <td colspan="5" style="text-align: center;">등록된 게시글이 없습니다.</td>
            </tr>
        </c:if>
        <c:forEach var="board" items="${boardList}">
            <tr>
                <td style="text-align: center;">
                        ${no}
                    <c:set var="no" value="${no - 1}"/>
                </td>
                <td>
                    <a href="./detail?idx=${board.idx}&pageNum=${pageNum}">
                        <c:if test="${board.relevel > 0}">
                            <c:forEach var="i" begin="1" end="${board.relevel}">
                                &nbsp;&nbsp;&nbsp;
                            </c:forEach>
                            <i class="bi bi-arrow-return-right"></i>
                        </c:if>
                            ${board.subject}
                        <c:if test="${board.imageCount == 1}">
                            <i class="bi bi-image"></i>
                        </c:if>
                        <c:if test="${board.imageCount > 1}">
                            <i class="bi bi-images"></i>
                        </c:if>
                        <c:if test="${board.commentCount > 0}">
                            <span class="badge bg-danger">${board.commentCount}</span>
                        </c:if>
                    </a>
                </td>
                <td style="text-align: center;">
                    ${board.writer}
                </td>
                <td style="text-align: center;">
                    <fmt:formatDate value="${board.writeDate}" pattern="yyyy-MM-dd"/>
                </td>
                <td style="text-align: center;">
                    ${board.readCount}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- 페이징 처리 -->
    <div>
        <ul class="pagination" style="display: flex; justify-content: center;">
            <!-- 이전 페이지로 이동 -->
            <c:if test="${pageNum != 1}">
                <li class="page-item">
                    <a class="page-link" href="./list?pageNum=${pageNum - 1}">&lt</a>&nbsp;
                </li>
            </c:if>
            <c:forEach var="pp" begin="${startPage}" end="${endPage}">
                <c:if test="${pp == pageNum}">
                    <li class="page-item">
                        <a class="page-link" style="color: red; cursor: default;">${pp}</a>
                    </li>
                </c:if>
                <c:if test="${pp != pageNum}">
                    <li class="page-item">
                        <a class="page-link" href="./list?pageNum=${pp}">${pp}</a>
                    </li>
                </c:if>
            </c:forEach>
            <!-- 다음 페이지로 이동 -->
            <c:if test="${pageNum != totalPage}">
                <li class="page-item">
                    <a class="page-link" href="./list?pageNum=${pageNum + 1}">&gt</a>
                </li>
            </c:if>
        </ul>
    </div>
</div>
</body>
</html>