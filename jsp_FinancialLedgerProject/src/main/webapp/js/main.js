// main.js
$(document).ready(function() {
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
        url: "../../controller/newUser.jsp",
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

    // reloadUserInfo 감지 시 userInfo.jsp 호출
    $(document).on("reloadUserInfo", () => {
        if (setInit) loadUserInfo();

    });
});

// welcome.jsp 호출
function loadWelcome() {
    $.ajax({
        url: "welcome.jsp",
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

// userInfo.jsp 호출
function loadUserInfo() {
    // 로드 시 setInit true로 설정하여 welcome 생략
    setInit = true;
    $.ajax({
        url: "userInfo.jsp",
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

// calendar.html 호출
function loadCalendar() {
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
}