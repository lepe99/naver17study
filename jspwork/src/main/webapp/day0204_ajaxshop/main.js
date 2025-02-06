$(document).ready(() => {
    // 로드 시 list 호출
    list();

    // select에 들어갈 이미지 리스트
    imageList();

    // 썸네일 기본값 설정
    $(".thumbnail").attr("src", $(".imageList").val());

    // select로 선택한 이미지 표시
    $(".imageList").change((e) => {
        $(".thumbnail").attr("src", $(e.target).val());
    });

    // 등록 버튼 클릭 시
    $("#addForm").submit((e) => {
        e.preventDefault();
        $.ajax({
            url: "insert.jsp",
            type: "get",
            dataType: "html",
            data: $(e.target).serialize(),
            success: () => {
                alert("상품이 추가되었습니다.");
                $("#addPrdtName").val("");
                $("#addPrdtColor").val("");
                $("#addPrdtCnt").val("");
                $("#addPrdtPrice").val("");
                $("#addPrdtDateIn").val("2025-01-01");
                list();
            }
        });
    });

    // 정렬 기준 바뀔 때 마다 list 재호출
    $("#selOrder").change(() => {
        list();
    });

    // 삭제 버튼 클릭 시 해당 상품 삭제
    $(document).on("click", ".del", (e) => {
        let ans = confirm("정말 삭제하시겠습니까?");
        if (!ans) return;
        let num = $(e.target).attr("num");

        $.ajax({
            url: "delete.jsp",
            type: "get",
            dataType: "html",
            data: {
                num: num
            },
            success: () => {
                list();
            }
        });
    });

    // 수정 폼 로드 시 해당 상품 정보 가져오기
    $(document).on("click", ".mod", (e) => {

        $.ajax({
            url: "load.jsp",
            type: "get",
            dataType: "json",
            data: {
                num: $(e.target).attr("num")
            },
            success: (data) => {
                $("#modNum").val(data.num);
                $(".imageList").val(data.prdtImg);
                $(".thumbnail").attr("src", data.prdtImg);
                $("#modPrdtName").val(data.prdtName);
                $("#modPrdtColor").val(data.prdtColor);
                $("#modPrdtCnt").val(data.prdtCnt);
                $("#modPrdtPrice").val(data.prdtPrice);
                $("#modPrdtDateIn").val(data.prdtDateIn);
            }
        });
    });

    // 수정 버튼 클릭 시 해당 상품 수정
    $("#modForm").submit((e) => {
        e.preventDefault();
        $.ajax({
            url: "update.jsp",
            type: "get",
            dataType: "html",
            data: $(e.target).serialize(),
            success: () => {
                list();
            }
        });
    });

    // 상품 검색
    $("#searchName").keyup((e) => {
        if (e.keyCode !== 13) return;
        list();
    });

    // 리스트 모양 기본값은 list
    $("#listStyle i").eq(1).css("color", "red");
    view = "list";

    // 리스트 모양 변경
    $("#listStyle i").click((e) => {
        view = $(e.target).attr("view");
        $(e.target).siblings().css("color", "#777");
        $(e.target).css("color", "red");
        list();
    });

    // 상세보기 클릭 시
    $(document).on("click", "i.detail", (e) => {
        let num = $(e.target).attr("num");
        // 상세 페이지로 이동
        location.href = `detail.jsp?num=${num}`;
    });

    // grid에서 이미지 클릭 시
    $(document).on("click", ".gridImg", (e) => {
        let num = $(e.target).attr("num");
        // 상세 페이지로 이동
        location.href = `detail.jsp?num=${num}`;
    });
});

// select에 들어갈 이미지 리스트
function imageList() {
    for (let i = 1; i <= 34; i++) {
        let s = `
        <option value="../image/photo2/${i}.${i === 24 ? "gif" : "jpg"}">사진 ${i}</option>
        `;
        $(".imageList").append(s);
    }
}

// list 함수
function list() {
    $.ajax({
        url: "list.jsp",
        type: "get",
        dataType: "json",
        data: {
            order: $("#selOrder").val(),
            search: $("#searchName").val()
        },
        success: (data) => {
            writeData(data);
        }
    });
}

// 데이터 출력 함수
function writeData(data) {

    let s = `총 ${data.length}개의 상품이 등록되어 있습니다.`;
    $("#listLength").html(s);

    let grid = "";
    let list = `
    <table class="table table-bordered">
    <thead>
        <tr>
            <th style="width: 50px">번호</th>
            <th style="width: 160px">상품명</th>
            <th style="width: 80px">색상</th>
            <th style="width: 50px">수량</th>
            <th style="width: 80px">단가</th>
            <th>상세보기</th>
        </tr>
    </thead>
    <tbody>
    `;

    $.each(data, (i, e) => {
        grid += `
        <figure>
        <div style="float: left; margin: 5px;">
            <img src="${e.prdtImg}" style="width: 100px; cursor: pointer;" num="${e.num}" class="gridImg">
        </div>
        <figcaption>
            <h6>상품명: ${e.prdtName}</h6>
            <h6>색상: ${e.prdtColor}</h6>
            <h6>개수: ${e.prdtCnt}</h6>
            <h6>가격: ${e.prdtPrice}</h6>
            <h6>입고일: ${e.prdtDateIn}</h6>
        
        <div style="clear: right; margin-left: 5px;">
            <i class="bi bi-pencil-square mod" num="${e.num}"
            data-bs-toggle="modal" data-bs-target="#modModal"></i>&nbsp;
            <i class="bi bi-trash del" num="${e.num}"></i>
        </div>
        </figcaption>
        </figure>
        `;

        list += `
        <tr>
            <td>${i + 1}</td>
            <td><img src="${e.prdtImg}">${e.prdtName}</td>
            <td>${e.prdtColor}</td>
            <td>${e.prdtCnt}</td>
            <td>${e.prdtPrice}</td>
            <td>
                <i class="bi bi-person-lines-fill detail" 
                style="font-size:1.5em;cursor:pointer;" num="${e.num}"></i>
            </td>
        </tr>
        `;

    });
    list += `</tbody></table>`;
    $("#prdtList").html(view === "grid" ? grid : list);
}

// detail.jsp의 openModModal
function openModModal() {
    $.ajax({
        url: "main.html",
        type: "get",
        dataType: "html",
        success: (data) => {
            let modal = $(data).find("#modModalContainer").html();
            $("body").append(modal);
            imageList();
            $("#modModal").modal("show");
        }
    });
}

// detail.jsp의 deletePrdt
function deletePrdt(num) {
    let ans = confirm("정말 삭제하시겠습니까?");
    if (!ans) return;

    $.ajax({
        url: "delete.jsp",
        type: "get",
        dataType: "html",
        data: {
            num: num
        },
        success: () => {
            alert("삭제되었습니다.");
            location.href = "main.html";
        }
    });
}