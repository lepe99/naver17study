// login.js
$(document).ready(function() {

    // 로그인 버튼 클릭 시
    $("#loginForm").submit((e) => {
        e.preventDefault();
        login();
    });

    // 회원가입 버튼 클릭 시
    $("#btnRegister").click(() => {
        location.href = "register.html";
    });
});

// 로그인 요청 처리
function login() {
    $.ajax({
        url: "loginProcess.jsp",
        type: "post",
        dataType: "json",
        data: $("#loginForm").serialize(),
        success: (response) => {
            if (response.success) location.href = "../main/main.html";
            else alert(response.message);
        },
        error: () => {
            alert("서버 요청 과정에서 오류가 발생하였습니다.");
        }
    });
}