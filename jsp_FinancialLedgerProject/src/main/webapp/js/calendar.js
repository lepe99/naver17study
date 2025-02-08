// calendar.js
$(document).ready(function() {

    // FullCalendar
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        locale: 'ko',
        headerToolbar: {
            start: 'prev,next today', // v6에서는 left, center, right 대신 start, center, end 사용
            center: 'title',
            end: 'dayGridMonth'
        },
        dayMaxEvents: true,

        // 이벤트 렌더링 함수 (미구현)
        eventContent: function(arg) {
            let income = arg.event.extendedProps.income; // 수입
            let expense = arg.event.extendedProps.expense; // 지출

            let html = `
              <div>
                  <div>${arg.event.title}</div>
                  <div>수입: ${income.toLocaleString()}원</div>
                  <div>지출: ${expense.toLocaleString()}원</div>
              </div>
          `;
            return { html: html };
        },

        // 날짜 클릭 이벤트 (미구현)
        dateClick: function(info) {
            // 클릭한 날짜에 해당하는 데이터를 찾음
            let clickedDate = info.dateStr; // YYYY-MM-DD 형식
            let dayData = calendar.getEvents().find(event => event.startStr === clickedDate);

            if (dayData) {
                // 상세보기 팝업 생성 및 표시
                showDetailsPopup(dayData);
            } else {
                // 해당 날짜에 데이터가 없는 경우 (선택 사항)
                alert("해당 날짜에 기록된 내역이 없습니다.");
            }
        },

        // view 변경 시 현재 뷰의 날짜 정보 세션에 가져오기
        viewDidMount: function(info) {
            let CurrentView = calendar.view.currentStart;
            let year = CurrentView.getFullYear();
            let month = CurrentView.getMonth() + 1;

            // ajax로 서버에 year, month 전송
            $.ajax({
                url: "setDate.jsp",
                type: "get",
                dataType: "json",
                data: {
                    year: year,
                    month: month
                },
                success: (response) => {
                    if (response.success === true) {
                        console.log(response.message);
                    } else {
                        console.log(response.message);
                    }
                },
                error: (xhr, status, error) => {
                    console.error("AJAX 오류:", status, error);
                    console.log("날짜 설정 중 오류가 발생했습니다.");
                }
            });
        }
    });
    calendar.render();

});