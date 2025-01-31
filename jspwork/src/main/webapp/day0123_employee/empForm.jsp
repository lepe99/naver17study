<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
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

        .tab th {
            background-color: orange;
        }

        .tab .photo {
            width: 50px;
            height: 60px;
            border: 1px solid gray;
            margin: 0 10px 0 0; /* 위, 오, 아래, 왼 (시계방향) */
        }

        .btn {
            width: 100px;
        }
    </style>
</head>
<body>
<form action="insertAction.jsp" method="post">
    <div style="margin: 30px;">
        <table class="tab table table-bordered" style="width: 400px;">
            <tr>
                <th style="width: 100px;">사원명</th>
                <td>
                    <label>
                        <input type="text" class="form-control" style="width: 150px;" required
                               autofocus name="empName">
                    </label>
                </td>
            </tr>
            <tr>
                <th style="width: 100px;">사진</th>
                <td class="input-group">
                    <img src="" class="photo">
                    <label>
                        <select class="form-select selPhoto" name="empPhoto" style="height: 60px">
                            <%
                                for (int i = 1; i <= 20; i++) {
                                    String s = "../image/photo/" + i + ".jpg"; %>
                            <option value="<%= s %>"<%= i == 17 ? " selected" : "" %>>사진 #<%= i %>
                            </option>
                            <% } %>
                        </select>
                        <script>
                            // 1. 선택된 옵션의 사진을 초기값으로 지정
                            $("img.photo").attr("src", $("select").val());
                            // 2. 사진 변경 시 .photo도 변경
                            $(".selPhoto").change((e) => {
                                $("img.photo").attr("src", $(e.target).val());
                            });
                        </script>
                    </label>
                </td>
            </tr>
            <tr>
                <th style="width: 100px;">입사일</th>
                <td>
                    <%
                        // 입사일의 초기값을 오늘 날짜로 설정
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String initVal = sdf.format(new Date());
                    %>
                    <label>
                        <input type="date" name="empJoin" value="<%= initVal %>">
                    </label>
                </td>
            </tr>
            <tr>
                <th style="width: 100px;">출생년도</th>
                <td>
                    <label>
                        <input type="number" class="form-control" name="empBirth" max="2025" required>
                    </label>
                </td>
            </tr>
            <tr>
                <th style="width: 100px;">혈액형</th>
                <td>
                    <%
                        String[] blood = {"A", "B", "O", "AB"};
                        for (String s : blood) { %>
                    <label>
                        <input type="radio" name="empBlood" value="<%= s %>"
                            <%= s.equals("B") ? "checked" : "" %>> <%= s %>형
                    </label>
                    &nbsp;
                    <% } %>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" class="btn btn-success btn-sm">사원등록</button>
                    <button class="btn btn-success btn-sm" onclick="history.back()">이전으로</button>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>