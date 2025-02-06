$(document).ready(() => {
    commentList();

    // 등록 버튼 클릭 시 댓글 등록
    $("#commentForm").submit((e) => {
        e.preventDefault();
        $.ajax({
            url: "../day0206_ajaxComment/insert.jsp",
            type: "get",
            dataType: "html",
            data: $(e.target).serialize(),
            success: () => {
                alert("리뷰가 등록되었습니다.");
                $("#star").val("5");
                $("#comment").val("");
                commentList();
            }
        });
    });

    // 정렬 기준 바뀔 때 마다 list 재호출
    $("#commentOrder").change(() => {
        commentList();
    });

    // 삭제 버튼 클릭 시 해당 댓글 삭제
    $(document).on("click", ".commentDel", (e) => {
        let ans = confirm("정말 삭제하시겠습니까?");
        if (!ans) return;

        $.ajax({
            url: "../day0206_ajaxComment/delete.jsp",
            type: "get",
            dataType: "html",
            data: {
                idx: $(e.target).attr("idx")
            },
            success: () => {
                commentList();
            }
        });
    });

    // 리뷰 나타내기 / 숨기기
    $("#commentLength").click(() => {
        $("#commentList").slideToggle("fast");
    });
});


// 리스트 출력
function commentList() {
    $.ajax({
        url: "../day0206_ajaxComment/list.jsp",
        type: "get",
        dataType: "json",
        data: {
            order: $("#commentOrder").val(),
            num: $("#commentNum").val()
        },
        success: (data) => {
            writeComment(data);
        }
    });
}

// 리스트 출력
function writeComment(data) {
    let s = ``;
    let len = `리뷰 (총 ${data.length}건)`;
    $.each(data, (i, e) => {
        let star = ["★☆☆☆☆", "★★☆☆☆", "★★★☆☆", "★★★★☆", "★★★★★"];
        s += `
        <div class="oneComment">
            <span style="margin-right: 10px;">${star[e.star - 1]}</span>
            <span>${e.message}</span>
            <i class="bi bi-trash commentDel" idx="${e.idx}" 
            style="float: right; color: #777; cursor: pointer;"></i>
            <span style="color: #ccc; float: right; font-size: 10px; margin-right: 10px;">${e.writeDate}</span>
        </div>
        <hr>
        `;
    });

    $("#commentList").html(s);
    $("#commentLength").html(len);
}

