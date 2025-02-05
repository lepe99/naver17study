$(document).ready(() => {
    list();
    // btnSave event
    $("#btnSave").click(() => {
        let avatar = $("#selAvatar").val();
        let nickname = $("#nickname").val();
        let message = $("#message").val();

        $.ajax({
            url: "insert.jsp",
            type: "get",
            dataType: "xml",
            data: {
                avatar: avatar,
                nickname: nickname,
                message: message
            },
            success: (data) => {
                alert($(data).find("result").text());
                $("#nickname").val("");
                $("#message").val("");
                list();
            }
        });
    });

    // del event
    $(document).on("click", ".del", (e) => {
        let ans = confirm("정말 삭제하시겠습니까?");
        if (!ans) return;
        let idx = $(e.target).attr("idx");

        $.ajax({
            url: "delete.jsp",
            type: "get",
            dataType: "html",
            data: {
                idx: idx
            },
            success: () => {
                list();
            }
        });
    });

    // mod event
    $(document).on("click", ".mod", (e) => {
        // 태그에 있는 idx 값 얻기
        let idx = $(e.target).attr("idx");
        // idx 값으로 서버에 요청
        // 서버에서는 idx 값으로 데이터를 얻어와서 json으로 응답
        // json을 이용해서 모달에 값을 세팅
        $.ajax({
            url: "updateMemo.jsp",
            type: "get",
            dataType: "json",
            data: {
                idx: idx
            },
            success: (data) => {
                $("#modIdx").val(data.idx);
                $("#modAvatar").val(data.avatar);
                $(".modPhotoAvatar").attr("src", data.avatar);
                $("#modNickname").val(data.nickname);
                $("#modMessage").val(data.message);
            }
        });
    });

    // submit event
    $("#modForm").submit((e) => {
        e.preventDefault(); // 기본 이벤트 무효화
        $.ajax({
            url: "update.jsp",
            type: "post",
            dataType: "html",
            data: $(e.target).serialize(), // form 데이터의 name, value를 get방식으로 반환
            success: () => {
                list();
            }
        });
    });

    $("#search").keyup((e) => {
        if (e.keyCode !== 13) return;
        let search = $(e.target).val();
        $.ajax({
            url: "list.jsp",
            type: "get",
            dataType: "json",
            data: {
                search: search
            },
            success: (data) => {
                writeData(data);
            }
        });
    });
});

function list() {
    $.ajax({
        url: "list.jsp",
        type: "get",
        dataType: "json",
        success: (data) => {
            writeData(data);
        }
    });
}

function writeData(data) {
    let s = "";
    s = `<b>총 ${data.length}개의 메모가 있습니다.</b><br>`;

    $.each(data, (i, e) => {
        s += `
        <img class="imgAvatar" src="${e.avatar}" align="left" hspace="5">
        <span class="nickname">${e.nickname}</span>
        <br>
        <span class="writeDate">${e.writeDate}</span>
        <br>
        <span class="message">${e.message}</span>
        <span style="float: right;">
        <i class="bi bi-pencil-square mod" style="cursor: pointer;" idx="${e.idx}"
        data-bs-toggle="modal" data-bs-target="#modModal"></i>&nbsp;
        <i class="bi bi-trash del" style="cursor: pointer;" idx="${e.idx}"></i>
        </span>
        <hr>
        `;
    });
    $("#memoList").html(s);
}
