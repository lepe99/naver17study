<%@ page import="simpleBoard.data.SimpleCommentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="simpleBoard.data.SimpleCommentDto" %>
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
    <!-- commentList.jsp -->
    <style>
        body * {
            font-family: 'Jua', sans-serif;
        }

        .bi {
            cursor: pointer;
        }
    </style>
</head>
<%
    int boardId = Integer.parseInt(request.getParameter("boardId"));
    List<SimpleCommentDto> list = new SimpleCommentDao().getThisComment(boardId);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");

%>
<body>
<div style="margin: 10px">
    <table class="tabComment table table-borderless">
        <caption style="caption-side: top">
            <h5><b>댓글목록</b>
                <b style="float: right;"><i class="bi bi-chat-dots"></i> <%= list.size() %>
                </b></h5>
        </caption>
        <%
            if (list.isEmpty()) { %>
        <tr style="height: 50px; text-align: center;">
            <td><b>등록된 글이 없습니다.</b></td>
        </tr>
        <% } else {
            for (SimpleCommentDto dto : list) { %>
        <tr>
            <td>
                <hr style="margin-top: -5px">
                <div style="margin-bottom: 10px">
                    <b>[<%= dto.getWriter() %>]</b>
                    <i class="remove bi bi-trash" style="float: right; font-size: 20px; margin-left: 5px;"
                       commentIdx="<%= dto.getCommentIdx() %>"></i>
                </div>
                <span><%= dto.getContent() %></span>
                <span style="float: right; color: #ccc; font-size: 0.8em;">
                    <%= sdf.format(dto.getWriteDate()) %>
                </span>
                <div class="updateForm"></div>
            </td>
        </tr>
        <% }
        } %>
    </table>
</div>

<script>
    $(".remove").click((e) => {
        let commentIdx = $(e.target).attr("commentIdx");
        if(confirm("댓글을 삭제합니다.")) {
            location.href = "commentDeleteAction.jsp?commentIdx=" + commentIdx
                + "&boardId=<%= boardId %>";
        }
    });
</script>
</body>
</html>