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

        #title body {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        a:link, a:visited {
            color: black;
            text-decoration: none;
        }

        a:hover {
            color: palevioletred;
        }

        ul.menu {
            list-style: none;
            margin: 10px;
        }

        ul.menu li {
            display: inline-block;
            width: 100px;
            height: 40px;
            margin-right: 10px;
            border: 1px solid gray;
            text-align: center;
            line-height: 40px;
            background-color: #ffe4e1;
            border-radius: 20px;
        }

        ul.menu li:hover {
            background-color: #d3d3d3;
            box-shadow: 5px 5px 5px gray;
        }

        .loginTable tbody th{
            background-color: #e0ffff;
        }

        img.profileImage {
            width: 40px;
            height: 40px;
            border: 1px solid gray;
            border-radius: 100px;
            margin-right: 10px;
            cursor: pointer;
            object-fit: cover;
        }
    </style>
    <script>
        $(document).ready(function () {
            // 로그인
            $(document).on("submit", "#loginForm", (e) => {
                e.preventDefault(); // 기존 이벤트 무효화
                let id = $("#loginId").val();
                let passwd = $("#loginPasswd").val();

                $.ajax({
                    url: "${root}/member/login",
                    type: "post",
                    dataType: "json",
                    data: {
                        id: id,
                        passwd: passwd
                    },
                    success: (response) => {
                        if (response.result === "success") {
                            $("loginId").val("");
                            $("loginPasswd").val("");

                            // 모달 닫기
                            $("#loginModal").modal("hide");
                            location.reload();
                        } else {
                            alert("아이디나 비밀번호가 맞지 않습니다");
                            $("#loginPasswd").val("");
                        }
                    }
                });
            });

            // 로그아웃
            $(document).on("click", "#logout", () => {
                $.ajax({
                    url: "${root}/member/logout",
                    type: "post",
                    success: () => {
                        location.reload();
                    }
                });
            });

            // 프로필 이미지 값이 없다면 기본 이미지로
            // if ($(".profileImage").attr("src") === "/save/") {
            if ($(".profileImage").attr("src").endsWith("member/")) {
                $(".profileImage").attr("src", "${root}/image/noimg.jpg");
            }

            // 프로필 이미지 클릭 시 멤버페이지 이동
            $(".profileImage").click(() => {
                location.href = "${root}/member/memberPage";
            });
        });
    </script>
</head>
<!-- 프로젝트 경로 구하기 - 절대 경로를 위한 코드 -->
<c:set var="root" value="${pageContext.request.contextPath}"/>
<body id="title">
<div style="margin: 10px;">
    <!-- 제목 클릭 시 메인 페이지로 이동 -->
    <h2 class="alert alert success">
        <a href="${root}/" style="color: black; text-decoration: none;">
            <img src="${root}/image/s4.jpg" style="width: 50px;">
            Spring Boot & MyBatis
        </a>
        <br>
        <span style="margin-left: 300px; font-size: 15px;">
            <c:if test="${sessionScope.loginOk != null}">
                <c:set var="objectStorageUrl" value="https://kr.object.ncloudstorage.com/bitcamp-bucket-120"/>
<%--                <img src="${root}/save/${sessionScope.loginImage}" class="profileImage">--%>
                <img src="${objectStorageUrl}/member/${sessionScope.loginImage}" class="profileImage">
                <span onclick="location.href='${root}/member/memberList'">${sessionScope.loginId} 님이 로그인중입니다.</span>
            </c:if>
        </span>
    </h2>
    <ul class="menu">
        <li><a href="${root}/">Home</a></li>
        <li><a href="${root}/shop/list">상품목록</a></li>
        <li><a href="${root}/member/form">회원가입</a></li>
        <li><a href="${root}/board/list">회원게시판</a></li>
        <c:if test="${sessionScope.loginOk == null}">
            <li><span data-bs-toggle="modal" data-bs-target="#loginModal"
                      style="cursor: pointer;">로그인</li>
        </c:if>
        <c:if test="${sessionScope.loginOk != null}">
            <li><span style="cursor: pointer" id="logout">로그아웃</span></li>
        </c:if>
    </ul>
</div>
<hr style="clear: both;">
<!-- The Login Modal -->
<div class="modal fade" id="loginModal">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">회원 로그인</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form id="loginForm">
                    <table class="loginTable">
                        <tbody>
                        <tr>
                            <th width="80">아이디</th>
                            <td>
                                <input type="text" id="loginId" placeholder="아이디"
                                       class="form-control" required="required">
                            </td>
                        </tr>
                        <tr>
                            <th width="80">비밀번호</th>
                            <td>
                                <input type="password" id="loginPasswd" placeholder="비밀번호"
                                       class="form-control" required="required">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <button type="submit" class="btn btn-sm btn-success">로그인</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger btnclose" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>