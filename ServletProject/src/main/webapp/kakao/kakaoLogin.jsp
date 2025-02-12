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
            font-family: "Jua", sans-serif;
        }

        a {
            text-decoration: none;
            color: black;
        }

        ul li {
            list-style: none;
        }

        div .kakaoLogin {
            width: 120px;
            height: 40px;
            border: 1px solid black;
            line-height: 40px;
            text-align: center;
            background-color: yellow;
            border-radius: 20px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div style="margin: 20px; width: 600px;">
    <ul>
        <script>
            // 로그인 여부 확인
            let s = "";
            if (localStorage.loginOk == null) {
                s = `
            <li>
                <a href="javascript:void(0)" onclick="kakaoLogin();">
                    <div class="kakaoLogin">카카오 로그인</div>
                </a>
            </li>
            `;
            } else {
                s = `
            <li>
                <a href="javascript:void(0)" onclick="kakaoLogout();">
                    <div class="kakaoLogin">카카오 로그아웃</div>
                </a>
                <h5 class="loginInfo" style="float: right;">
                    <img src="\${localStorage.photo}" style="border-radius: 15px; width: 30px; height: 30px;">
                    \${localStorage.writer}님 환영합니다.
                </h5>
            </li>
            `;
            }
            document.write(s);
        </script>
    </ul>
</div>
<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
    Kakao.init("836dbbe8a6877273235783af3253add8"); //발급받은 키 중 javascript키를 사용해준다.
    console.log(Kakao.isInitialized()); // sdk 초기화 여부 판단
    //카카오로그인
    function kakaoLogin() {
        Kakao.Auth.login({
            success: function (response) {
                Kakao.API.request({
                    url: "/v2/user/me",
                    success: function (response) {
                        console.log(response);

                        // 로컬 스토리지에 닉네임, 프로필사진, 로그인여부 저장
                        localStorage.writer = response.properties.nickname;
                        localStorage.photo = response.properties.profile_image;
                        localStorage.loginOk = true;
                        location.reload();
                    },
                    fail: function (error) {
                        console.log(error);
                    },
                });
            },
            fail: function (error) {
                console.log(error);
            },
        });
    }

    //카카오로그아웃
    function kakaoLogout() {
        if (Kakao.Auth.getAccessToken()) {
            Kakao.API.request({
                url: "/v1/user/unlink",
                success: function (response) {
                    console.log(response);

                    // 로컬 스토리지에 있는 닉네임, 프로필사진, 로그인여부 삭제
                    localStorage.removeItem("writer");
                    localStorage.removeItem("photo");
                    localStorage.removeItem("loginOk");
                    location.reload();
                },
                fail: function (error) {
                    console.log(error);
                },
            });
            Kakao.Auth.setAccessToken(undefined);
        }
    }
</script>
</body>
</html>