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

        .tabBoard th {
            background-color: orange;
        }

        .btn {
            width: 100px;
        }
    </style>
</head>
<body>
<div style="margin: 30px; width: 400px;">
    <form action="insertAction.jsp" method="post">
        <table class="tabBoard table table-bordered">
            <caption style="caption-side: top">
                <h5><b>글쓰기</b></h5>
            </caption>
            <tr>
                <th style="width: 100px">작성자</th>
                <td>
                    <input type="text" name="writer" class="form-control"
                    autofocus required>
                </td>
            </tr>
            <tr>
                <th style="width: 100px">제목</th>
                <td>
                    <input type="text" name="subject" class="form-control" required>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <textarea style="width: 100%; height: 150px;" class="form-control"
                              name="content" required></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <button type="submit" class="btn btn-outline-secondary btn-sm">글 저장</button>
                    <button type="reset" class="btn btn-outline-secondary btn-sm">초기화</button>
                    <!-- 리셋 : 폼 데이터 초기화 -->
                    <button class="btn btn-outline-secondary btn-sm"
                    onclick="history.back()">취소</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>