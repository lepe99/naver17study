$(() => {
    // 총을 클릭 시 0~11 사이 난수 발생 후 해당 번째의 인형을 사라지게
    // 이미 사라진 경우는 메세지
    $(".gun").click((e) => {
        // 0~11 사이 난수 발생
        let idx = Math.floor(Math.random() * 12);
        if ($(".sun img").eq(idx).is(":hidden")) {
            $("#msg").html((idx + 1) + "번 인형은 없습니다.");
        } else {
            $("#msg").html((idx + 1) + "번 인형을 맞췄습니다.");
            $(".sun img").eq(idx).hide();
        }

        // 모든 인형이 사라진 경우 메세지
        let n = $(".sun img:hidden").length;
        if (n === 12) {
            $("#msg").html("Game Over");
        }
    });

    // 돈 클릭 시 돈은 사라지고 나머지 모두 초기화
    $(".money img").click((e) => {
       $(".sun img").show();
       $("#msg").html("");
       // $(e.target).css("visibility", "hidden"); // 자리 차지
       $(e.target).css("display", "none"); // 자리 차지 안함
    });
});