// userInfo.js
$(document).ready(function() {
    // 로그아웃 버튼 클릭 시
    $("#btnLogout").click(() => {
        $.ajax({
            url: "../../controller/logout.jsp",
            type: "get",
            dataType: "json",
            success: (response) => {
                if (response.success === true) {
                    location.href = "../user/login.html";
                } else {
                    alert(response.message);
                }
            },
            error: (xhr, status, error) => {
                console.error("AJAX 오류:", status, error);
                alert("로그아웃 중 오류가 발생했습니다.");
            }
        });
    });

    // 수입/지출 추가 버튼 클릭 시
    $("#btnAddTransaction").click(() => {
        $("#transactionModal").modal("show");
        loadCategoryListToTransactionForm();
    });

    // 카테고리 관리 버튼 클릭 시
    $("#btnCategoryManagement").click(() => {
        $("#categoryModal").modal("show");
        loadCategoryList();
    });
});
