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

        #showImg {
            width: 120px;
            height: 160px;
            border: 1px solid gray;
            object-fit: cover;
        }

        .tab1 tbody th {
            background-color: #f0f8ff;
        }
    </style>
    <script>
        let overlap = false;

        $(document).ready(function () {

            // submit 이벤트가 발생했을 때
            $("#memberForm").submit(() => {
                // check() 함수에서 false가 반환되면 submit 이벤트를 중단
                return check();
            });

            // 중복확인 버튼 클릭 시
            $("#idChk").click(() => {
                // 임시
                checkId();
            });

            // 중복확인 이후 아이디 변경 시 중복확인 초기화
            $("input[name=id]").keyup(() => {
                overlap = false;
            });

            // 이미지 클릭 시 파일 선택 인풋 열기
            $("#showImg").click(() => {
                $("input[name=upload]").trigger("click");
            });

            // 이미지 지정하지 않았을 시 기본 이미지로
            $("#showImg").attr("src", "../image/noimg.jpg");

            // 파일 선택 시 미리보기 변경
            $("input[name=upload]").change((e) => {
                preview(e.target);
            });
        });

        // 파일 선택 시 미리보기
        function preview(file) {
            let f = file.files[0]; // 파일 객체
            if(!f.type.match("image.*")) { // 이미지 파일만 걸러줌
                alert("이미지 파일만 업로드 가능합니다.");
                return;
            }

            if (f) {
                let reader = new FileReader();
                reader.onload = (e) => { // 읽기 동작이 성공적으로 완료되었을 때
                    $("#showImg").attr("src", e.target.result); // 이미지 소스에 파일 경로를 넣어줌
                }
                reader.readAsDataURL(f);
            }
        }

        // id 중복확인 끝났는지, 비밀번호 일치여부 확인
        function check() {
            let p1 = $("input[name=passwd]").val();
            let p2 = $("input[name=passwdChk]").val();
            if (p1 !== p2) {
                alert("비밀번호가 일치하지 않습니다.");
                return false;
            }

            if (!overlap) {
                alert("아이디 중복확인을 해주세요.");
                return false;
            }
        }

        // 아이디 중복확인
        function checkId() {
            let id = $("input[name=id]").val();
            if (id === "") {
                alert("아이디를 입력해주세요.");
                return false;
            }

            $.ajax({
                url: "checkId",
                type: "post",
                dataType: "json",
                data: {id: id},
                success: (res) => {
                    if (res.result === "success") {
                        alert("사용 가능한 아이디입니다.");
                        overlap = true;
                    } else {
                        alert("이미 사용중인 아이디입니다.");
                        overlap = false;
                    }
                }
            });
        }
    </script>
</head>
<body>
<jsp:include page="../layout/title.jsp" />
<div style="margin: 10px 30px; width: 500px;">
    <form action="insert" method="post" enctype="multipart/form-data" id="memberForm">
        <table class="table table-bordered tab1">
            <tbody>
            <tr>
                <td style="width: 150px;" rowspan="4">
                    <input type="file" name="upload" hidden><br>
                    <img src="" id="showImg">
                </td>
                <th style="width: 70px;">이름</th>
                <td><input type="text" name="name" class="form-control" required></td>
            </tr>
            <tr>
                <th>아이디</th>
                <td class="input-group">
                    <input type="text" name="id" class="form-control" required>
                    <button type="button" class="btn btn-danger btn-sm" id="idChk">중복확인</button>
                </td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td class="input-group">
                    <input type="password" name="passwd" class="form-control" required placeholder="비밀번호">
                    <input type="password" name="passwdChk" class="form-control" required placeholder="비밀번호 확인">
                </td>
            </tr>
            <tr>
                <th>전화번호</th>
                <td><input type="text" name="hp" class="form-control"></td>
            </tr>
            <tr>
                <th>주소</th>
                <td colspan="2">
                    <input type="text" name="address" class="form-control" required>
                </td>
            </tr>
            <tr>
                <td colspan="3" style="text-align: center;">
                    <button type="submit" class="btn btn-success btn-sm">회원가입</button>
                </td>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>