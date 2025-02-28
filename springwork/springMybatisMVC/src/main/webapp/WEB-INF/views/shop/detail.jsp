<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>502 jsp study</title>
    <link
            href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu
            &family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
            rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <style>
        body * {
            font-family: 'Jua', sans-serif;
        }

        #detail body {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        #imageList img {
            width: 100px;
            height: 120px;
            object-fit: cover; /* 이미지 비율 유지 */
            display: block; /* 이미지 수직으로 나열 */
            margin-bottom: 10px;
            cursor: pointer;
            border: 2px solid #ccc;
        }

        #imageList {
            overflow: auto;
            width: 120px;
            height: 360px;
            border: 2px solid #ccc;
            border-radius: 10px;
        }

        #mainImage img {
            width: 300px;
            height: 360px;
            object-fit: cover;
            border: 3px solid #ccc;
            border-radius: 10px;
        }

        #entityDetail {
            clear: both;
            margin-top: 20px;
        }

        #entityDetail h6 {
            margin-left: 20px;
        }

        #imageContainer {
            display: flex;
            justify-content: space-between;
        }

        #imageUpload {
            display: none;
        }

        .addImage {
            font-size: 1.5em;
            cursor: pointer;
            margin-left: 10px;
            margin-right: 10px;
        }

        .commentList {
            margin: 10px 10px;
        }

        .commentImage {
            margin: 0;
            width: 50px;
            height: 50px;
            object-fit: cover;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .commentDate {
            font-size: 0.8em;
            color: #777;
        }

        .commentDel, .commentLike {
            cursor: pointer;
            float: right;
        }

        .commentLike {
            color: black;
        }
    </style>
    <script>
        $(document).ready(function () {

            tooltip(); // bs5 툴팁 관련
            commentList(); // 로딩 시 댓글 출력

            // 댓글 카메라 아이콘 클릭
            $(".addImage").click(() => {
                $("#imageUpload").trigger("click");
            });

            // 댓글 파일 업로드 시
            let image;
            $("#imageUpload").change((e) => {
                image = e.target.files[0];
                $(".addImage").attr("title", image.name);
                tooltip();
            });

            // 댓글 등록 버튼 클릭
            $("#btnAddComment").click(() => {
                // 댓글 입력하지 않았을 시
                const message = $("#message").val();
                if (message.trim() === "") {
                    alert("댓글을 입력하세요");
                    return;
                }
                let form = new FormData();
                form.append("num", "${entity.num}");
                form.append("message", message);
                form.append("file", image);

                $.ajax({
                    url: "./addComment",
                    type: "post",
                    data: form,
                    processData: false,
                    contentType: false,
                    success: (res) => {
                        if (res === "success") {
                            commentList();
                            $("#message").val("");
                            image = null;
                            $(".addImage").attr("title", "");
                            alert("댓글이 등록되었습니다.");
                        } else alert("댓글 등록 실패");
                    }
                });
            });

            // 댓글 이미지 클릭 시 모달
            $(document).on("click", ".commentImage", (e) => {
                let src = e.target.src;
                $("#modalImage").attr("src", src);
                $("#commentImageModal").modal("show");
            });

            // 이미지 클릭시 메인 이미지 변경
            $("#imageList img").click((e) => {
                let src = e.target.src;
                $("#mainImage img").attr("src", src);
            });

            // 삭제 버튼 클릭시
            $(".btnDel").click(() => {
                if (confirm("정말 삭제하시겠습니까?")) {
                    location.href = "./delete?num=${entity.num}&oldImages=${entity.image}";
                }
            });

            // 댓글 삭제 버튼 클릭시
            $(document).on("click", ".commentDel", (e) => {
                let idx = $(e.target).attr("idx");
                let image = $(e.target).attr("image");
                commentDel(idx, image);
            });

            // 댓글 목록 버튼 클릭시 댓글 목록 띄우기, 애니메이션 주기
            $("#btnCommentList").click(() => {
                $(".commentList").slideToggle(300);
            });
        });

        // 댓글 목록 출력
        function commentList() {
            $(".commentList").empty();
            $.ajax({
                url: "./commentList",
                type: "post",
                dataType: "json",
                data: {num: "${entity.num}"},
                success: (res) => {
                    $.each(res, (i, e) => {
                        if (e.image === null) e.image = "../image/noimg.jpg";
                        let s = `
                        <div style="display: flex; align-items: flex-start;">
                            <div>
                                <img src="${objectStorageUrl}/comment/\${e.image}" class="commentImage">
                            </div>
                            <div style="width: 390px; margin-left: 10px;">
                                <span class="commentDate">\${e.regDate}</span>
                                <i class="bi bi-trash commentDel" idx="\${e.idx}" image="\${e.image}"></i><br>
                                <span>\${e.message}</span>
                                <i class="bi bi-hand-thumbs-up commentLike" onclick="commentLike(\${e.idx})"
                                        value="\${e.idx}" like="0">\${e.likes}</i>
                            </div>
                        </div>
                        <hr>
                        `;
                        $(".commentList").append(s);

                        // 댓글 갯수 뱃지에 출력
                        $("#cntComment").text(res.length);
                    });
                }
            });
        }

        // 댓글 삭제
        function commentDel(idx, image) {
            if (!confirm("정말 삭제하시겠습니까?")) return;

            $.ajax({
                url: "./deleteComment",
                type: "post",
                data: {
                    idx: idx,
                    image: image
                },
                success: (res) => {
                    if (res === "success") {
                        commentList();
                    } else {
                        alert("댓글 삭제 실패");
                    }
                }
            });
        }

        // 댓글 추천
        function commentLike(idx) {
            // 이미 추천한 댓글인지 확인
            let icon = $(`.commentLike[value='\${idx}']`);
            let like = icon.attr("like");
            let likes = Number(icon.text());
            console.log(likes);
            if (like === "0") {
                likes++;
                icon.css("color", "palevioletred");
                icon.attr("like", "1");
            } else {
                likes--;
                icon.css("color", "black");
                icon.attr("like", "0");
            }
            icon.text(likes);

            $.ajax({
                url: "./updateLike",
                type: "post",
                data: {idx: idx, likes: likes},
                success: (res) => {
                    if (res !== "success") {
                        alert("추천 실패");
                    }
                }
            });


        }

        // bs5 툴팁 관련
        function tooltip() {
            var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
            var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
                return new bootstrap.Tooltip(tooltipTriggerEl)
            })
        }
    </script>
</head>
<body id="detail">
<jsp:include page="../layout/title.jsp"/>
<div style="margin: 20px; width: 440px;">
    <div id="imageContainer">
        <div id="imageList">
            <c:forTokens items="${entity.image}" delims="," var="image">
                <img src="${objectStorageUrl}/shop/${image}" style="max-width: 200px;">
            </c:forTokens>
        </div>
        <div id="mainImage">
            <img src="${objectStorageUrl}/shop/${entity.image.split(',')[0]}" style="max-width: 400px;">
        </div>
    </div>
    <div id="entityDetail">
        <hr>
        <h6>상품명 : ${entity.name}</h6>
        <h6>가격 : ${entity.price}</h6>
        <h6>색상 : <span style="color: ${entity.color}">${entity.color}</span></h6>
        <h6>수량 : ${entity.qty}</h6>
        <h6>입고일 : ${entity.arrivalDate}</h6>
        <h6>등록일 : ${entity.regDate}</h6>
    </div>
    <hr>
    <div id="btnList">
        <button type="button" class="btn btn-outline-secondary" onclick="location.href='./addForm'"
                style="margin-left: 20px;">등록
        </button>
        <button type="button" class="btn btn-outline-secondary" onclick="location.href='./list'">목록</button>
        <button type="button" class="btn btn-outline-secondary"
                onclick="location.href='./updateForm?num=${entity.num}'">수정</button>
        <button type="button" class="btn btn-outline-secondary btnDel">삭제</button>
        <button type="button" class="btn btn-success" id="btnCommentList" style="float: right;">
            댓글 <span class="badge bg-danger" id="cntComment">0</span>
        </button>
    </div>
    <hr>
    <div class="commentForm input-group">
        <input type="file" id="imageUpload">
        <i class="bi bi-camera-fill addImage"
           data-bs-toggle="tooltip" data-bs-placement="bottom" title="등록된 이미지가 없습니다."></i>
        <input type="text" id="message" class="form-control" placeholder="댓글을 입력하세요">
        <button type="button" class="btn btn-info btn-sm" id="btnAddComment">등록</button>
    </div>
    <hr>
    <div class="commentList"></div>
    <!-- The Modal -->
    <div class="modal fade" id="commentImageModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">사진</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <img src="" style="width: 100%;" id="modalImage">
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>