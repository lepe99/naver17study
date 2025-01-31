<%@ page import="simpleBoard.data.SimpleBoardDao" %>
<%@ page import="simpleBoard.data.SimpleBoardDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

        .tabBoard thead th {
            background-color: #aad8e6;
            text-align: center;
        }

        .tabBoard a {
            text-decoration: none;
            color: black;
            cursor: pointer;
        }

        #subject { /* 제목 칸 초과시 뒤 ...으로 */
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
            display: block;
            max-width: 200px;
        }
    </style>
</head>
<%
    // dao 생성
    SimpleBoardDao dao = new SimpleBoardDao();
    // 전체 데이터 가져오기
    List<SimpleBoardDto> list = dao.getAllData();
    // 날짜 포맷
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

    // 출력할 시작 번호
    int startNo = list.size();
%>
<body>
<div style="margin: 30px;">
    <table class="tabBoard table table-bordered" style="width: 540px;">
        <caption style="caption-side: top">
            <h6><b>총 <%= list.size() %>개의 글이 있습니다.</b>
                <button class="btn btn-outline-success btn-sm" style="float: right;"
                        onclick="location.href='boardForm.jsp'"><i class="bi bi-pencil-fill"></i> 글쓰기
                </button>
            </h6>
        </caption>
        <thead>
        <tr>
            <th style="width: 50px;">번호</th>
            <th style="width: 220px;">제목</th>
            <th style="width: 100px;">작성자</th>
            <th style="width: 100px;">작성일</th>
            <th>조회수</th>
        </tr>
        </thead>
        <tbody>
        <% if (list.isEmpty()) { %>
        <tr style="height: 50px; text-align: center;">
            <td colspan="5"><b>등록된 글이 없습니다.</b></td>
        </tr>
        <% } else {
            for (SimpleBoardDto dto : list) { %>
        <tr style="text-align: center">
            <td><%= startNo-- %>
            </td>
            <td style="text-align: left">
                <div id="subject">
                    <a href="contentDetail.jsp?boardId=<%= dto.getBoardId() %>">
                        <%= dto.getSubject() %>
                    </a>
                </div>
            </td>
            <td><%= dto.getWriter() %>
            </td>
            <td><%= sdf.format(dto.getWriteDate()) %>
            </td>
            <td><%= dto.getReadCount() %>
            </td>
        </tr>
        <% }
        } %>
        </tbody>
    </table>
</div>
</body>
</html>