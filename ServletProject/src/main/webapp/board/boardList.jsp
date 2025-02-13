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

        a.pageA:hover {
            text-decoration: underline;
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
            <b style="width: 100px;">총 ${totalCount}개의 글이 있습니다.</b>
            <button type="button" class="btn btn-outline-secondary" style="float: right;"
                    onclick="location.href='./writeForm'">글쓰기
            </button>
            <hr style="margin-top: 20px; margin-bottom: 10px;">
            <form action="./list" method="post">
                <div class="input-group" style="float: right; width: 350px;">
                    <select class="form-select" name="field">
                        <option value="subject">제목</option>
                        <option value="content">내용</option>
                        <option value="writer">작성자</option>
                    </select>
                    <input type="text" class="form-control" placeholder="검색어를 입력하세요" name="search" style="width: 170px;" value="">
                    <button class="btn btn-outline-secondary" type="submit">검색</button>
                </div>
            </form>
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
                    <td style="text-align: center;">
                            ${no}
                        <!-- 반복문 돌 때 마다 1씩 감소 -->
                        <c:set var="no" value="${no - 1}"/>
                    </td>
                    <td><!-- 제목 (num, pageNum 보내기) -->
                        <a style="cursor: pointer; text-decoration: none; color: black;"
                           href="./detail?num=${dto.num}&pageNum=${pageNum}">
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

    <!-- 페이지 번호 -->
    <div style="text-align: center">
        <!-- 첫 페이지로 이동 -->
        <a class="prev" href="./list?pageNum=1&field=${field}&search=${search}">&lt&lt</a>&nbsp;
        <!-- 이전 페이지로 이동 -->
        <a class="prev" href="./list?pageNum=${pageNum - 1}&field=${field}&search=${search}">&lt</a>&nbsp;
        <c:forEach var="pp" begin="${startPage}" end="${endPage}">
            <c:if test="${pp == pageNum}">
                <a class="pageA" href="./list?pageNum=${pp}&field=${field}&search=${search}" style="color: red;">${pp}</a>
            </c:if>
            <c:if test="${pp != pageNum}">
                <a class="pageA" href="./list?pageNum=${pp}&field=${field}&search=${search}">${pp}</a>
            </c:if>
        </c:forEach>
        <!-- 다음 페이지로 이동 -->
        &nbsp;<a class="next" href="./list?pageNum=${pageNum + 1}&field=${field}&search=${search}">&gt</a>
        <!-- 마지막 페이지로 이동 -->
        &nbsp;<a class="next" href="./list?pageNum=${totalPage}&field=${field}&search=${search}">&gt&gt</a>
    </div>
    <script>
        // 이전 페이지가 없다면 이전 버튼 비활성화, 다음 페이지가 없다면 다음 버튼 비활성화
        if (${pageNum} === 1 && ${totalPage} === 1) {
            $(".prev").attr("href", "#");
            $(".prev").css("color", "#ccc");
            $(".prev").css("cursor", "default");
            $(".next").attr("href", "#");
            $(".next").css("color", "#ccc");
            $(".next").css("cursor", "default");
        } else if (${pageNum} === 1) {
            $(".prev").attr("href", "#");
            $(".prev").css("color", "#ccc");
            $(".prev").css("cursor", "default");
        } else if (${pageNum} === ${totalPage}) {
            $(".next").attr("href", "#");
            $(".next").css("color", "#ccc");
            $(".next").css("cursor", "default");
        }
    </script>
</div>


</body>
</html>