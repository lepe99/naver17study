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
            error: () => {
                alert("수입/지출 내역 삭제 실패.");
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