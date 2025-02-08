// main.js
// 로그인 여부 확인
$.ajax({
    url: "loginCheck.jsp",
    type: "GET",
    dataType: "json",
    success: (data) => {
        if (!data.login) {
            alert("잘못된 접근, 로그인 페이지로 이동합니다.");
            location.href = "../user/login.html";
        }
    },
    error: (xhr, status, error) => {
        console.error("AJAX 오류:", status, error);
    }
});

// 캘린더 호출
$.ajax({
    url: "calendar.html",
    type: "GET",
    dataType: "html",
    success: (data) => {
        $("#calendarContainer").html(data);
    },
    error: (xhr, status, error) => {
        console.error("AJAX 오류:", status, error);
        $("#calendarContainer").html("<p>달력을 불러오는 데 실패했습니다.</p>");
    }
});

// userInfo or welcome 호출
$.ajax({
    url: "welcome.jsp",
    type: "GET",
    dataType: "json",
    success: (data) => {
        if (data.newUser) loadWelcome();
        else loadUserInfo();
    },
    error: (xhr, status, error) => {
        console.error("AJAX 오류:", status, error);
        $("#userInfoContainer").html("<p>유저 정보를 불러오는 데 실패했습니다.</p>");
    }
});

// welcome.html 호출
function loadWelcome() {
    $.ajax({
        url: "welcome.html",
        type: "GET",
        dataType: "html",
        success: (data) => {
            $("#infoContainer").html(data);
        },
        error: (xhr, status, error) => {
            console.error("AJAX 오류:", status, error);
            $("#infoContainer").html("<p>환영 페이지를 불러오는 데 실패했습니다.</p>");
        }
    });
}

// userInfo.html 호출
function loadUserInfo() {
    $.ajax({
        url: "userInfo.html",
        type: "GET",
        dataType: "html",
        success: (data) => {
            $("#infoContainer").html(data);
        },
        error: (xhr, status, error) => {
            console.error("AJAX 오류:", status, error);
            $("#infoContainer").html("<p>유저 정보 페이지를 불러오는 데 실패했습니다.</p>");
        }
    });
}

$(document).ready(function() {

});
