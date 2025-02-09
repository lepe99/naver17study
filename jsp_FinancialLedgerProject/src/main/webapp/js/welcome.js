// welcome.js
$(document).ready(function() {
    // 입력 버튼 클릭 시
    $("#initBalanceForm").submit((e) => {
        const initBalance = $("#initBalance").val();
        if (initBalance === "") {
            alert("초기 자금을 입력해주세요.");
            return;
        }
        e.preventDefault();
        $.ajax({
            url: "../../controller/setInitBalance.jsp",
            type: "get",
            dataType: "json",
            data: {
                initBalance: initBalance
            },
            success: (response) => {
                if (response.success === true) {
                    alert(response.message);
                    setInit = true;
                    loadUserInfo();
                } else {
                    alert(response.message);
                }
            },
            error: (xhr, status, error) => {
                console.error("AJAX 오류:", status, error);
                alert("초기 자금 설정 중 오류가 발생했습니다.");
            }
        });
    });
});
