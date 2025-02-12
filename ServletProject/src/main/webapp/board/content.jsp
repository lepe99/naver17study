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

        .day {
            color: gray;
            font-size: 13px;
        }

        .smallPhoto {
            width: 40px;
            height: 40px;
            border: 1px solid #ccc;
            border-radius: 100px;
            margin-right: 10px;
            cursor: pointer;
        }
    </style>
    <script>
        $(document).ready(function () {
            $(".btn").addClass("btn btn-outline-secondary btn-sm").css("width", "100px");
        });
    </script>
</head>
<body>
<div style="margin: 20px; width: 600px;">
    <h1><b>${dto.subject}</b></h1>
    <div>
        <img src="${dto.photo}" class="smallPhoto" style="text-align: left;" data-bs-toggle="modal" data-bs-target="#imgModal">
        <span>${dto.writer}</span>
        <span class="day">
            <fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/>
            &nbsp;&nbsp;&nbsp;
            조회 ${dto.readcount}
        </span>
    </div>
    <hr>
    <pre style="font-size: 17px;">${dto.content}</pre>
    <div style="margin-top: 50px;">
        <button type="button" class="btn" onclick="location.href='./writeForm'">글쓰기</button>
        <button type="button" class="btn" onclick="location.href='./list'">목록</button>
        <button type="button" class="btn" onclick="location.href
                ='./writeForm?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}'">답변
        </button>
        <button type="button" class="btn" onclick="location.href='./updateForm?num=${dto.num}'">수정</button>
        <button type="button" class="btn" onclick="location.href='./deletePassForm?num=${dto.num}'">삭제</button>

    </div>
</div>

<!-- The Modal -->
<div class="modal fade" id="imgModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">사진 상세보기</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body" style="color: li">
                <img src="${dto.photo}" style="width: 100%; ">
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
            </div>

        </div>
    </div>
</div>
</body>
</html>