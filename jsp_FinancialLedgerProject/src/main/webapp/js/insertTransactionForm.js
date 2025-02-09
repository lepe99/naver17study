// insertTransactionForm.js
$(document).ready(function() {

    // 카테고리 목록 로드
    loadCategoryListToTransactionForm();

    // 유형 변경 시 카테고리 목록 재업로드
    $("#addTransactionType").change(() => {
        loadCategoryListToTransactionForm();
    });

    // 초기 설정: 주기 관련 필드 숨기기
    // "단일/고정" select 변경 시
    $("#addTransactionFrequency").change((e) => {
        if ($(e.target).val() === "recurring") {
            $("#singleDateDiv").hide();
            $("#frequencyDiv").show();
            $("#dateRangeDiv").show();
            $("#addTransactionDate").prop("disabled", true);
        } else {
            $("#singleDateDiv").show();
            $("#frequencyDiv").hide();
            $("#dateRangeDiv").hide();
            $("#addTransactionDate").prop("disabled", false);
        }
    });

    // "분류 추가" 버튼 클릭 시
    $("#btnAddCategory").click(() => {
        $("#transactionModal").modal("hide");
        $("#categoryModal").modal("show");
        loadCategoryList();
    });



    // 폼 제출 처리
    $("#transactionForm").submit((e) => {
        e.preventDefault();
        $.ajax({
            url: "../../controller/addTransaction.jsp",
            type: "get",
            dataType: "json",
            data: $(e.target).serialize(),
            success: (response) => {
                if (response.success) {
                    alert(response.message);
                    loadUserInfo();
                    loadCalendar();
                    // 추후 캘린더 호출 작성
                } else alert(response.message);
            },
            error: function() {
                alert("수입/지출 내역 추가 실패.");
            }
        });
    });
});


function loadCategoryListToTransactionForm() {
    $.ajax({
        url: "../../controller/categoryList.jsp",
        type: "get",
        dataType: "json",
        success: (data) => {
            let s = "";
            $.each(data, (i, e) => {
                if (e.categoryType === $("#addTransactionType").val()) {
                    s += `
                    <option value="${e.id}">${e.name}</option>
                    `;
                }
            });
            $("#addCategory").html(s);
        },
        error: (xhr, status, error) => {
            console.error("AJAX 오류:", status, error);
            alert("카테고리 목록을 불러오는 데 실패했습니다.");
        }
    });
}