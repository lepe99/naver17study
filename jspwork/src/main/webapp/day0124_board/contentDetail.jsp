<%@ page import="simpleBoard.data.SimpleBoardDao" %>
<%@ page import="simpleBoard.data.SimpleBoardDto" %>
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

        .btn {
            width: 90px;
        }

        .date {
            color: #ccc;
            font-size: 0.8em;
            float: right;
        }
    </style>
</head>
<%
    // 1. boardId 읽어오기
    int boardId = Integer.parseInt(request.getParameter("boardId"));

    // 2. dao 생성, updateReadCount() 호출
    SimpleBoardDao dao = new SimpleBoardDao();
        dao.updateReadCount(boardId);

    // 3. num에 해당하는 데이터 가져오기
    SimpleBoardDto dto = dao.getData(boardId);

    // 4. 날짜 영식 분까지
    SimpleDateFormat sdf = new SimpleDateFormat(("yyyy.MM.dd HH:mm"));
%>
<body>
<div style="margin: 20px; width: 500px;">
    <table class="table">
        <caption style="caption-side: top">
            <h2><b><%= dto.getSubject() %></b></h2>
        </caption>
        <tr>
            <td>
                <b>작성자 : <%= dto.getWriter() %></b>
                <span class="date"><%= sdf.format(dto.getWriteDate()) %></span>
            </td>
        </tr>
        <tr>
            <td>
                <span>조회수 : <%= dto.getReadCount() %></span><hr>
                <pre><%= dto.getContent() %></pre>
<%--                <div><%= dto.getContent().replace("\n", "<br>") %></div>--%>
            </td>
        </tr>
        <tr>
            <td style="text-align: center">
                <button class="btn btn-outline-success btn-sm"
                        onclick="location.href='boardForm.jsp'">글쓰기</button>
                <button class="btn btn-outline-secondary btn-sm"
                        onclick="location.href='boardList.jsp'">목록</button>
                <button class="btn btn-outline-secondary btn-sm"
                        onclick="location.href='updateForm.jsp?boardId=<%= dto.getBoardId() %>'">수정</button>
                <button class="btn btn-outline-secondary btn-sm"
                        onclick="del(<%= dto.getBoardId() %>)">삭제</button>
                <script type="text/javascript">
                    function del(boardId) {
                        if (confirm("해당 게시글을 삭제합니다")) {
                            location.href = "deleteAction.jsp?boardId=" + boardId;
                        }
                    }
                </script>
            </td>
        </tr>
        <tr>
            <td>
                <jsp:include page="commentForm.jsp?boardId=<%= dto.getBoardId() %>"/>
            </td>
        </tr>
        <tr>
            <td>
                <jsp:include page="commentList.jsp?boardId=<%= dto.getBoardId() %>"/>
            </td>
        </tr>
    </table>
</div>
</body>
</html>