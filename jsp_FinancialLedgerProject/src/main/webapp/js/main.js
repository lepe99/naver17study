// main.js
$(document).ready(function() {

    // calendarContainer에 calendar.html을 삽입
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
});