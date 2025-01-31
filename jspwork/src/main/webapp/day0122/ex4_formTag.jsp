<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>502 jsp study</title>
    <link
            href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
            rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <style>
        body * {
            font-family: 'Jua', sans-serif;
        }
    </style>
</head>
<body>
<div style="margin: 30px">
    <form action="./ex4_action.jsp" method="post"> <!-- post 써볼거임 -->
        <table class="table table-bordered" style="width: 300px;">
            <tr>
                <th width="100">아이디</th>
                <td>
                    <input type="text" name="myId" class="form-control" required value="12345"> <!-- required: 필수입력 -->
                </td>
            </tr>
            <tr>
                <th width="100">비밀번호</th>
                <td>
                    <input type="password" name="myPass" class="form-control" required>
                </td>
            </tr>
            <tr>
                <th width="100">이름</th>
                <td>
                    <input type="text" name="myName" class="form-control" required>
                </td>
            </tr>
            <tr>
                <th width="100">운전면허</th>
                <td>
                    <label>
                        <!-- checkbox : value 가 없을 경우 체크 시 "on" 안하면 null
                         value 지정 시 체크할 경우 "value 값" -->
                        <input type="checkbox" name="driver" value="yes">운전면허
                    </label>
                </td>
            </tr>
            <tr>
                <th width="100">주거지</th>
                <td>
                    <label>
                        <input type="radio" name="homeAddr" value="서울" checked>서울
                    </label>
                    <label>
                        <input type="radio" name="homeAddr" value="경기">경기
                    </label>
                    <br>
                    <label>
                        <input type="radio" name="homeAddr" value="제주">제주
                    </label>
                    <label>
                        <input type="radio" name="homeAddr" value="부산">부산
                    </label>
                </td>
            </tr>
            <tr>
                <th width="100">취미</th>
                <td>
                    <label>
                        <input type="checkbox" name="hobby" value="게임">게임
                    </label>
                    <label>
                        <input type="checkbox" name="hobby" value="낚시">낚시
                    </label>
                    <br>
                    <label>
                        <input type="checkbox" name="hobby" value="여행">여행
                    </label>
                    <label>
                        <input type="checkbox" name="hobby" value="등산">등산
                    </label>
                </td>
            </tr>
            <tr>
                <th width="100">좋아하는 음식</th>
                <td>
                    <select class="form-select" name="myFood">
                        <option selected disabled hidden>선택하세요</option>
                        <option value="2.jpg">닭꼬치</option>
                        <option value="4.jpg">소고기카레</option>
                        <option value="11.jpg">망고빙수</option>
                        <option value="10.jpg">햄마요덮밥</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th width="100">글자색</th>
                <td>
                    <input type="color" name="fColor" value="#ccffcc">
                </td>
            </tr>
            <tr>
                <th width="100">생년월일</th>
                <td>
                    <input type="date" name="myBirth" value="2010-01-12">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="image" value="서버에 전송" src="../image/mycar/mycar13.png" style="width: 100px">
                    <%--input type="image"는 submit 버튼을 이미지로 대체하는 태그--%>
                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>