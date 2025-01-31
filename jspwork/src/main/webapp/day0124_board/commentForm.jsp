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
    <!-- commentForm.jsp -->
    <style>
        body * {
            font-family: 'Jua', sans-serif;
        }

        form label {
            float: left;
        }
    </style>
</head>
<%
    int boardId = Integer.parseInt(request.getParameter("boardId"));
%>
<body>
<div style="margin: 10px;">
    <form action="commentInsertAction.jsp" method="post">
        <table>
            <caption style="caption-side: top">
                <h5><b>댓글쓰기</b></h5>
            </caption>
            <tr>
                <th style="width: 50px">작성자</th>
                <label>
                    <input type="hidden" name="boardId" value="<%= boardId %>">
                </label>
                <td>
                    <label>
                        <input type="text" class="form-control" style="width: 120px;"
                               name="writer" required placeholder="닉네임">
                    </label>
                    <button type="submit" class="btn btn-outline-success btn-sm" style="float: right;">작성</button>
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <label>
                        <textarea style="width: 400px; height: 80px;" class="form-control"
                                  name="content" required placeholder="댓글을 입력하세요"></textarea>
                    </label>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>