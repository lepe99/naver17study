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

        .profileImage2 {
            width: 180px;
            height: 180px;
            border-radius: 100px;
            object-fit: cover;
            border: 1px solid gray;
        }

        .changeProfileImage {
            position: relative;
        }
    </style>
    <script>
        $(document).ready(function () {
            $(".changeProfileImage").click((e) => {
                $("#fileUpload").trigger("click");
            });

            // 사진 변경
            $("#fileUpload").change((e) => {
                let f = e.target.files[0]; // 파일 객체
                if (!f.type.match("image.*")) { // 이미지 파일만 걸러줌
                    alert("이미지 파일만 업로드 가능합니다.");
                    return;
                }

                if (f) {
                    let reader = new FileReader();
                    reader.onload = (e) => { // 읽기 동작이 성공적으로 완료되었을 때
                        $(".profileImage2").attr("src", e.target.result); // 이미지 소스에 파일 경로를 넣어줌
                    }
                    reader.readAsDataURL(f);
                }

                let form = new FormData();
                form.append("upload", f);
                form.append("num", "${member.num}");

                // multipart 형식으로 전송
                $.ajax({
                    url: "updateImage",
                    type: "post",
                    data: form,
                    contentType: false,
                    processData: false, // 뺴먹지 말자..
                    success: (response) => {
                        if (response !== "success") alert("이미지 변경 실패");
                    }
                });
            });

            // 회원 탈퇴
            $("#btnMemberDelete").click((e) => {
                if (!confirm("정말 탈퇴하시겠습니까?")) return;

                $.ajax({
                    url: "memberPageDelete",
                    type: "post",
                    data: {num: e.target.value},
                    success: () => {
                        location.href = "../"
                    }
                });
            });

            // 프로필 이미지 값이 없다면 기본 이미지로
            // if ($(".profileImage2").attr("src") === "../save/") {
            if ($(".profileImage2").attr("src") === "${objectStorageUrl}/member/") {
                $(".profileImage2").attr("src", "${root}/image/noimg.jpg");
            }

            // 수정 폼 비밀번호 일치 여부, ajax
            $("#updateMemberForm").submit((e) => {
                e.preventDefault();
                let p1 = $("#passwd").val();
                let p2 = $("#passwdChk").val();
                if (p1 !== p2) {
                    alert("비밀번호가 일치하지 않습니다.");
                    return false;
                }

                $.ajax({
                    url: "updateMember",
                    type: "post",
                    dataType: "text",
                    data: $("#updateMemberForm").serialize(),
                    success: (response) => {
                        if (response === "success") {
                            alert("회원정보 수정 완료");
                            location.reload();
                        } else {
                            alert("회원정보 수정 실패");
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>
<jsp:include page="../layout/title.jsp"/>
<div style="margin: 30px 50px 30px 100px; display: inline-block; vertical-align: top;">
<%--    <img src="../save/${member.image}" class="profileImage2">--%>
    <!-- naver storage에 저장된 이미지를 불러옴 -->
    <img src="${objectStorageUrl}/member/${member.image}" class="profileImage2">
    <input type="file" id="fileUpload" name="upload" hidden>
    <i class="bi bi-camera-fill changeProfileImage"></i>
</div>
<div style="display: inline-block; margin: 20px 50px;">
    <h6>회원명 : ${member.name}</h6>
    <h6>아이디 : ${member.id}</h6>
    <h6>핸드폰 : ${member.hp}</h6>
    <h6>주소 : ${member.address}</h6>
    <h6>가입일 : <fmt:formatDate value="${member.regDate}" pattern="yyyy-MM-dd HH:mm"/></h6>
    <br><br>
    <button type="button" class="btn btn-danger btn-sm" id="btnMemberDelete" value="${member.num}">회원탈퇴</button>
    <button type="button" class="btn btn-info btn-sm" id="btnMemberUpdate" value="${member.num}"
            data-bs-toggle="modal" data-bs-target="#updateMemberModal">회원정보수정
    </button>
</div>
<!-- The Modal -->
<div class="modal fade" id="updateMemberModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">회원 정보 수정</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form method="post" action="updateMember" id="updateMemberForm">
                    <input type="hidden" name="num" value="${member.num}">
                    <table class="table table-bordered">
                        <tr>
                            <th>아이디</th>
                            <td>${member.id}</td>
                        </tr>
                        <tr>
                            <th>비밀번호</th>
                            <td><input type="password" id="passwd" name="passwd" class="form-control"></td>
                        </tr>
                        <tr>
                            <th>비밀번호 확인</th>
                            <td><input type="password" id="passwdChk" class="form-control"></td>
                        </tr>
                        <tr>
                            <th>이름</th>
                            <td><input type="text" name="name" class="form-control" value="${member.name}"></td>
                        </tr>
                        <tr>
                            <th>핸드폰</th>
                            <td><input type="text" name="hp" class="form-control" value="${member.hp}"></td>
                        </tr>
                        <tr>
                            <th>주소</th>
                            <td><input type="text" name="address" class="form-control" value="${member.address}"></td>
                        </tr>
                    </table>
                </form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="submit" form="updateMemberForm" class="btn btn-success">수정</button>
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
            </div>

        </div>
    </div>
</div>
<!-- 내가 쓴 게시글 -->
<div style="margin: 20px; width: 600px; clear: both;">
    <h5>내가 쓴 게시글</h5>
    <table class="table table-bordered myBoardsTable">
        <thead>
        <tr>
            <th style="width: 60px; text-align: center;">번 호</th>
            <th style="width: 350px;">제 목</th>
            <th style="width: 120px; text-align: center;">작성일</th>
            <th style="text-align: center;">조회수</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${empty myBoards}">
            <tr>
                <td colspan="4" style="text-align: center;">작성한 게시글이 없습니다.</td>
            </tr>
        </c:if>
        <c:forEach var="board" items="${myBoards}" varStatus="i">
            <tr>
                <td style="text-align: center;">${i.count}</td>
                <td>
                    <a href="../board/detail?idx=${board.idx}">
                        <c:if test="${board.relevel > 0}"><mark>[답글]</mark></c:if>
                        ${board.subject}
                    </a>
                </td>
                <td style="text-align: center;">
                    <fmt:formatDate value="${board.writeDate}" pattern="yyyy-MM-dd"/>
                </td>
                <td style="text-align: center;">${board.readCount}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>