//listDailyTransactionForm.js
$(document).ready(function() {

    // 삭제 아이콘 클릭 시
    $(document).on("click", ".delete-icon", (e) => {
        if (!confirm("정말 삭제하시겠습니까?")) return;
        $.ajax({
            url: "../../controller/deleteTransaction.jsp",
            type: "get",
            dataType: "json",
            data: {
                id: $(e.target).attr("data-id"),
                recurringId: $(e.target).attr("recurring-id")
            },
            success: (response) => {
                if (response.success) {
                    alert(response.message);
                    // 모달 닫기
                    $("#dailyTransactionModal").modal("hide");
                    loadUserInfo();
                    loadCalendar();
                } else alert(response.message);
            },
            // 콘솔에 자세한 오류 로그 출력
            error: (xhr, status, error) => {
                console.error("AJAX 오류:", status, error);
                alert("서버 요청 중 오류가 발생했습니다.");
            }
        });
    });

    // 수입/지출 추가 버튼 클릭 시
    $("#btnAddTransaction2").click(() => {
        $("#dailyTransactionModal").modal("hide");
        $("#transactionModal").modal("show");
        loadCategoryListToTransactionForm();
    });
});