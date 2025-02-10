// insertCategory.js
$(document).ready(function() {

    // 폼 제출 처리 (AJAX)
    $("#categoryForm").submit((e) => {
        e.preventDefault();
        $.ajax({
            url: "../../controller/addCategory.jsp",  // 카테고리 추가 처리
            type: "get",
            dataType: "json",
            data: $(e.target).serialize(),
            success: (response) => {
                if (response.success) {
                    alert(response.message);
                    // 카테고리 목록 업데이트
                    loadCategoryList();
                } else alert(response.message);
            },
            error: () => {
                alert("카테고리 추가 실패.");
            }
        });
    });

    // 카테고리 유형 변경 시
    $("#addCategoryType").change(() => {
        loadCategoryList();
    });

    // 카테고리 삭제 이벤트
    $("#categoryList").on("click", ".delete-icon-category", (e) => {
        if (!confirm("정말 삭제하시겠습니까?")) return;
        $.ajax({
            url: "../../controller/deleteCategory.jsp",
            type: "get",
            dataType: "json",
            data: {
                id: $(e.target).data("id")
            },
            success: (response) => {
                if (response.success) {
                    alert(response.message);
                    loadCategoryList();
                } else alert(response.message);
            },
            error: () => {
                alert("카테고리 삭제 실패.");
            }
        });
    });
});

// 카테고리 목록 불러오기
function loadCategoryList() {
    $.ajax({
        url: "../../controller/categoryList.jsp",
        type: "get",
        dataType: "json",
        success: (data) => {
            let s = "";
            $.each(data, (i, e) => {
                if (e.categoryType === $("#addCategoryType").val()) {
                    s += `
                    <li class="list-group-item category-item">
                        <span>${e.name}</span>
                        <i class="bi bi-trash delete-icon-category" style="float: right; color: palevioletred; cursor: pointer;" 
                        data-id="${e.id}"></i>
                    </li>
                    `;
                }
            });
            $("#categoryList").html(s);
        },
        error: (xhr, status, error) => {
            console.error("AJAX 오류:", status, error);
            alert("카테고리 목록을 불러오는 데 실패했습니다.");
        }
    });
}