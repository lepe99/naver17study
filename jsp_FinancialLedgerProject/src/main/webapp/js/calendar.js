// calendar.js
$(document).ready(function () {

    // FullCalendar
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        locale: 'ko',
        headerToolbar: {
            start: 'prev,next today',
            center: 'title',
            end: 'dayGridMonth'
        },
        dayMaxEvents: true,

        // 날짜 클릭 이벤트 (미구현)
        dateClick: function (info) {
            let dayData = JSON.parse(localStorage.getItem("monthlyData") || "{}")[info.dateStr];
            // 클릭한 날짜에 해당하는 데이터를 찾음
            let clickedDate = info.dateStr; // YYYY-MM-DD 형식
            if (dayData) {
                // 상세보기 팝업 생성 및 표시
                showDetailsPopup(clickedDate);
            } else {
                // 해당 날짜에 데이터가 없는 경우 (선택 사항)
                alert("해당 날짜에 기록된 내역이 없습니다.");
            }
        },

        // view 변경 시 현재 뷰의 날짜 정보 세션에 가져오기
        datesSet: (info) => {
            let CurrentView = calendar.view.currentStart;
            let year = CurrentView.getFullYear();
            let month = CurrentView.getMonth() + 1;
            getAndStoreMonthlyData(year, month).then(() => {
                updateAllDayCells();
            });
        },
    });
    calendar.render();
});

// 월별 데이터 가져와 local storage에 저장
function getAndStoreMonthlyData(year, month) {
    // ajax로 서버에 year, month 전송
    return $.ajax({
        url: "../../controller/getMonthlyTransactions.jsp",
        type: "get",
        dataType: "json",
        data: {
            year: year,
            month: month
        },
        success: (data) => {
            // userInfo.jsp 업데이트
            $(document).trigger("reloadUserInfo");

            // local storage에 저장
            localStorage.setItem("monthlyData", JSON.stringify(data));
        },
        error: (xhr, status, error) => {
            console.error("AJAX 오류:", status, error);
            console.error("데이터를 가져오는 중 오류가 발생했습니다.");
        }
    });
}

// 날짜 칸의 내용 업데이트
function renderDayCellContent(info) {
    // 날짜 칸의 날짜 정보 문자열로 받아오기
    let year = info.date.getFullYear();
    let month = info.date.getMonth() + 1;
    let day = info.date.getDate();
    let dateStr = `${year}-${String(month).padStart(2, '0')}-${String(day).padStart(2, '0')}`;

    // local storage에서 데이터 가져오기
    let monthlyData = JSON.parse(localStorage.getItem("monthlyData") || "{}");
    let dayData = monthlyData[dateStr];

    // 기존 내용 삭제
    $(info.el).find(".dayContent").remove();

    // 날짜 칸에 데이터가 있는 경우
    if (dayData) {
        let s = `
                <div class="dayContent">
                    <div class="dayIncome">${dayData.income === 0 ? "." : dayData.income.toLocaleString()}</div>
                    <div class="dayExpense">${dayData.expense === 0 ? "." : dayData.expense.toLocaleString()}</div>
                </div>
                `;
        $(info.el).find(".fc-daygrid-day-top").after(s); // 숫자 아래 내용 출력
    }
}

// 모든 날짜 셀 업데이트
function updateAllDayCells() {
    $(".fc-daygrid-day").each(function () { // 모든 날짜 셀 선택
        let dateStr = $(this).data("date"); // data-date 속성에서 날짜 가져오기

        // 가짜 info 객체 생성 (renderDayCellContent에 필요한 정보)
        let fakeInfo = {
            date: new Date(dateStr),
            el: this // 현재 날짜 셀 요소
        };
        renderDayCellContent(fakeInfo); // 각 셀에 대해 renderDayCellContent 호출
    });
}

// 상세보기 팝업 생성
function showDetailsPopup(clickedDate) {
    $.ajax({
        url: "../../controller/listDailyTransaction.jsp",
        type: "get",
        dataType: "json",
        data: {
            date: clickedDate
        },
        success: (data) => {
            let incomeHtml = "";
            let expenseHtml = "";
            $.each(data, (i, e) => {
                if (e.transactionType === "income") {
                    incomeHtml += `
                    <tr>
                        <td>${e.categoryName}</td>
                        <td style="color: deepskyblue;">${e.amount.toLocaleString()}</td>      
                        <td>${e.description}</td> 
                        <td><i class="bi bi-trash delete-icon" data-id="${e.id}" recurring-id="${e.recurringId}"></i></td>
                    </tr>             
                    `;
                } else {
                    expenseHtml += `
                    <tr>
                        <td>${e.categoryName}</td>
                        <td style="color: palevioletred;">${(-e.amount).toLocaleString()}</td>      
                        <td>${e.description}</td> 
                        <td><i class="bi bi-trash delete-icon" data-id="${e.id}" recurring-id="${e.recurringId}"></i></td>
                    </tr>  
                    `;
                }
            });
            let dayData = JSON.parse(localStorage.getItem("monthlyData") || "{}");
            let dailyData = dayData[clickedDate];
            // yyyy-mm-dd 형식의 날짜를 한글로 변환
            let dateFormat = clickedDate.replace(/(\d{4})-(\d{2})-(\d{2})/, "$1년 $2월 $3일");
            $("#dailyTransactionModalLabel").html(`${dateFormat}`);
            $("#dailyIncome").html(dailyData.income.toLocaleString());
            $("#dailyExpense").html(dailyData.expense.toLocaleString());
            $("#dailySum").html((dailyData.total).toLocaleString());
            $("#incomeData").html(incomeHtml);
            $("#expenseData").html(expenseHtml);
            // 모달 열기
            $("#dailyTransactionModal").modal("show");
        },
    });
}