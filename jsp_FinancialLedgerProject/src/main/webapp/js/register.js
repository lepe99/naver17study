$(document).ready(function() {
    // 회원가입 버튼 클릭 시
    $("#registerForm").submit((e) => {
        e.preventDefault();
        register();
    });
});

// 회원가입
function register() {
    $.ajax({
        url: "registerProcess.jsp",
        type: "post",
        dataType: "json",
        data: $("#registerForm").serialize(),
        success: (response) => {
            if (response.success) {
                alert(response.message);
                location.href = "login.jsp";
            }
            else alert(response.message);
        },
        error: () => {
            alert("서버 요청 과정에서 오류가 발생하였습니다.");
        }
    });
}