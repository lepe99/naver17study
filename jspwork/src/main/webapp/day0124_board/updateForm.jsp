<%@ page import="simpleBoard.data.SimpleBoardDto" %>
<%@ page import="simpleBoard.data.SimpleBoardDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>502 jsp study</title>
    <link
            href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu
            &family=Jua&family=NaboardId+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
            rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <style>
        body * {
            font-family: 'Jua', sans-serif;
        }

        .tabBoard th {
            background-color: orange;
        }

        .btn {
            width: 100px;
        }
    </style>
</head>
<%
    //1. boardId 읽어오기
    int boardId = Integer.parseInt(request.getParameter("boardId"));
    //2. dao선언
    SimpleBoardDao dao = new SimpleBoardDao();
    //3. dto얻기
    SimpleBoardDto dto = dao.getData(boardId);

%>
<body>
<div style="margin: 30px;width: 400px;">
    <form action="./updateAction.jsp" method="post">
        <!-- hidden  -->
        <input type="hidden" name="boardId" value="<%= boardId %>">

        <table class="table table-bordered tabBoard">
            <caption style="caption-side: top">
                <h5><b>글수정</b></h5>
            </caption>
            <tr>
                <th style="width: 100px">작성자</th>
                <td>
                    <label>
                        <input type="text" name="writer" class="form-control"
                               autofocus required value="<%= dto.getWriter() %>">
                    </label>
                </td>
            </tr>
            <tr>
                <th width="100">제목</th>
                <td>
                    <label>
                        <input type="text" name="subject" class="form-control"
                               required value="<%= dto.getSubject() %>">
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label>
                        <textarea style="width: 100%; height:150px;"
                                  class="form-control" name="content"
                                  required="required"><%= dto.getContent() %></textarea>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <button type="submit" class="btn btn-sm btn-outline-secondary">
                        글수정
                    </button>

                    <button type="button" class="btn btn-sm btn-outline-secondary"
                            onclick="history.back()">취소
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>