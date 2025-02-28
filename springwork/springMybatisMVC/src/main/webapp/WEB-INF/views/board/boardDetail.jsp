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

        .writerImage {
            width: 50px;
            height: 50px;
            border-radius: 100px;
            border: 1px solid gray;
            margin-right: 10px;
            text-align: left;
        }

        .date {
            font-size: 0.8em;
            color: gray;
        }

        .commentWriterImage {
            width: 30px;
            height: 30px;
            border-radius: 100px;
            border: 1px solid gray;
            display: inline-block;
            vertical-align: top;
        }

        .preview {
            max-width: 38px;
            height: 38px;
            object-fit: cover;
            display: inline-block;
            margin-top: -2px;
            position: relative;
            left: -23px;
            margin-right: -24px;
        }

        .btnCommentImageDelete {
            font-size: 1.1em;
            position: relative;
            left: -30px;
            top: 0;
            cursor: pointer;
        }

        .btnCommentImageDelete:hover,
        .btnCommentDelete:hover,
        .btnCommentUpdate:hover {
            color: red;
        }
    </style>
    <script>
        $(document).ready(function () {

            // 프로필 이미지가 없을 경우 대체 이미지로 변경
            if ($(".writerImage").attr("src").endsWith("member/")) {
                $(".writerImage").attr("src", "../image/noimg.jpg");
            }

            // 삭제 버튼 클릭 시
            $("#btnDelete").click(() => {
                if (confirm("정말 삭제하시겠습니까?")) {
                    location.href = "./delete?idx=${board.idx}&pageNum=${pageNum}";
                }
            });

            // 댓글 이미지 미리보기
            $("#addComment input[name=upload]").change((e) => {
                let reader = new FileReader();
                reader.onload = (e) => {
                    $("#addCommentPreview").attr("src", e.target.result);
                };
                reader.readAsDataURL(e.target.files[0]);
            });

            // 댓글 등록 시
            $("#addComment").submit((e) => {
                e.preventDefault();
                let formData = new FormData($("#addComment")[0]);
                $.ajax({
                    url: "comment/insert",
                    type: "post",
                    data: formData,
                    contentType: false,
                    processData: false,
                    success: (response) => {
                        if (response === "success") {
                            $("#addComment")[0].reset();
                            location.reload();
                        } else {
                            alert("댓글 등록에 실패했습니다.");
                        }
                    }
                });
            });

            // 댓글 수정 버튼 클릭 시
            $(".btnCommentUpdate").click((e) => {
                let idx = $(e.target).attr("idx");
                let num = "${board.idx}";
                let content = $(`#comment_\${idx} .comment pre`).text();
                let defaultImage = $(`#comment_\${idx} .comment img`).attr("src");
                let image = "";
                if (defaultImage === undefined) defaultImage = "../image/noimg.jpg";
                else image = defaultImage.split("/").pop();
                let s = `
                <form action="comment/update" method="post" enctype="multipart/form-data"
                        class="updateComment" id="updateComment_\${idx}">
                    <input type="hidden" name="idx" value="\${idx}">
                    <input type="hidden" name="image" value="\${image}">
                    <textarea name="content" class="form-control" style="width: 100%; height: 60px;">\${content}</textarea>
                    <div style="width: 100%;">
                        <input type="file" name="upload" class="form-control"
                                style="width: 70%; margin-top: 10px; display: inline-block;">
                        <i class="bi bi-file-earmark-x btnCommentImageDelete" idx=\${idx}></i>
                        <img src="\${defaultImage}" class="preview" id="updateCommentPreview">
                        <button type="submit" class="btn btn-primary" style="width: 20%; margin-top: -3px;">수정</button>
                    </div>
                </form>
                `;

                $(`#comment_\${idx} .comment`).html(s);
            });

            // 댓글 수정 이미지 미리보기
            $("body").on("change", ".updateComment input[name=upload]", (e) => {
                let reader = new FileReader();
                reader.onload = (e) => {
                    $("#updateCommentPreview").attr("src", e.target.result);
                };
                reader.readAsDataURL(e.target.files[0]);
            });

            // 댓글 수정
            $("body").on("submit", ".updateComment", (e) => {
                e.preventDefault();
                let formData = new FormData($(".updateComment")[0]);
                $.ajax({
                    url: "comment/update",
                    type: "post",
                    data: formData,
                    contentType: false,
                    processData: false,
                    success: (response) => {
                        if (response === "success") {
                            location.reload();
                        } else {
                            alert("댓글 수정에 실패했습니다.");
                        }
                    }
                });
            });

            // 댓글 삭제
            $(".btnCommentDelete").click((e) => {
                if (!confirm("정말 삭제하시겠습니까?")) return;

                let idx = $(e.target).attr("idx");
                let commentImage = $(`#comment_\${idx} .comment img`).attr("src")
                let image;

                if (commentImage === undefined) image = "";
                else image = commentImage.split("/").pop();

                $.ajax({
                    url: "comment/delete",
                    type: "post",
                    data: {
                        idx: idx,
                        image: image
                    },
                    success: (response) => {
                        if (response === "success") {
                            $(`#comment_\${idx}`).remove();
                        } else {
                            alert("댓글 삭제에 실패했습니다.");
                        }
                    }
                });
            });

            // 댓글 이미지 삭제
            $("body").on("click", ".btnCommentImageDelete", (e) => {
                $(e.target).prev().val("");
                $(e.target).next().attr("src", "../image/noimg.jpg");
                let idx = $(e.target).attr("idx");

                if (idx !== undefined) {
                    $(`#updateComment_\${idx} input[name=image]`).val("");
                }
            });

            // 댓글 이미지 모달
            $("body").on("click", ".commentImage", (e) => {
                let src = $(e.target).attr("src");
                $("#modalImage").attr("src", src);
                $("#commentImageModal").modal("show");
            });


        });
    </script>
</head>
<body>
<!-- 로그인 하지 않을 경우 이전 페이지로 이동 -->
<c:if test="${empty sessionScope.loginOk}">
    <script>
        alert("로그인이 필요합니다.");
        history.back();
    </script>
</c:if>
<jsp:include page="../layout/title.jsp"/>

<div style="margin: 30px; width: 500px;">
    <h3><b>${board.subject}</b></h3>
    <img src="${objectStorageUrl}/member/${profileImage}" class="writerImage" style="vertical-align: top;">
    <div style="display: inline-block">
        <span>${board.writer}</span><br>
        <span class="date">
            <fmt:formatDate value="${board.writeDate}" pattern="yyyy-MM-dd HH:mm"/>
            &nbsp;&nbsp;조회수 ${board.readCount}
        </span>
    </div>
    <hr>
    <pre style="margin-top: 30px; font-size:  15px;">${board.content}</pre>
    <div style="margin-top: 30px;">
        <c:forEach var="image" items="${board.images}">
            <img src="${objectStorageUrl}/board/${image}" style="max-width: 300px;">
        </c:forEach>
    </div>
    <div style="margin-top: 30px;" id="divBtn">
        <button type="button" class="btn btn-success btn-sm" style="width: 80px;"
                onclick="location.href='./writeForm'"><i class="bi bi-pencil-square"></i> 글쓰기
        </button>
        <button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px;"
                onclick="location.href='./writeForm?idx=${board.idx}&regroup=${board.regroup}&restep=${board.restep}&relevel=${board.relevel}&pageNum=${pageNum}'">
            <i class="bi bi-reply"></i> 답글
        </button>
        <c:if test="${sessionScope.loginId == board.id}">
            <button type="button" class="btn btn-secondary btn-sm" style="width: 80px;"
                    onclick="location.href='./updateForm?idx=${board.idx}&pageNum=${pageNum}'">
                <i class="bi bi-pencil-square"></i> 수정
            </button>
            <button type="button" class="btn btn-danger btn-sm" id="btnDelete" style="width: 80px;">
                <i class="bi bi-trash"></i> 삭제
            </button>
        </c:if>
        <button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px; margin-left: 50px;"
                onclick="location.href='./list?pageNum=${pageNum}'"><i class="bi bi-list-ul"></i> 목록
        </button>
    </div>
    <hr>
    <div class="commentForm">
        <h5>댓글 작성</h5>
        <form action="comment/insert" method="post" enctype="multipart/form-data" id="addComment">
            <input type="hidden" name="num" value="${board.idx}">
            <textarea name="content" class="form-control" style="width: 100%; height: 100px;"></textarea>
            <div style="width: 100%;">
                <input type="file" name="upload" class="form-control"
                       style="width: 70%; margin-top: 10px; display: inline-block;">
                <i class="bi bi-file-earmark-x btnCommentImageDelete"></i>
                <img src="../image/noimg.jpg" class="preview" id="addCommentPreview">
                <button type="submit" class="btn btn-primary" style="width: 20%; margin-top: -3px;">등록</button>
            </div>
        </form>
    </div>
    <hr>
    <h5>댓글 목록 <span class="badge bg-danger">${board.commentCount}</span></h5>
    <div id="commentList">
        <c:if test="${empty commentList}">
            <div style="margin: 10px;">
                <span>댓글이 없습니다.</span>
            </div>
        </c:if>
        <c:forEach var="comment" items="${commentList}">
            <div style="margin: 10px;" id="comment_${comment.idx}">
                <img src="${frontUrl}/member/${comment.writerImage}${backUrl}" class="commentWriterImage">
                <div style="display: inline-block; vertical-align: bottom;">
                    <c:if test="${comment.id == sessionScope.loginId}">
                        <mark>${comment.writer}</mark>&nbsp;
                    </c:if>
                    <c:if test="${comment.id != sessionScope.loginId}">
                        <span>${comment.writer}</span>&nbsp;
                    </c:if>
                    <span class="date">
                        <fmt:formatDate value="${comment.writeDate}" pattern="yyyy-MM-dd HH:mm"/>
                    </span>
                </div>
                <div style="display: inline-block; margin-left: 235px; vertical-align: bottom;">
                    <c:if test="${sessionScope.loginId == comment.id}">
                        <i class="bi bi-trash btnCommentDelete"
                           style="float: right; cursor: pointer;" idx="${comment.idx}"></i>
                        <i class="bi bi-pencil-square btnCommentUpdate"
                           style="float: right; cursor: pointer; margin-right: 10px;" idx="${comment.idx}"></i>
                    </c:if>
                </div>
                <div style="margin-top: 10px;" class="comment">
                    <c:if test="${not empty comment.image}">
                        <img src="${objectStorageUrl}/comment/${comment.image}" class="commentImage"
                             style="max-height: 70px; display: inline-block;">
                    </c:if>
                    <pre style="margin-top: 10px; font-size: 15px; display: inline-block;">${comment.content}</pre>
                </div>
                <hr>
            </div>
        </c:forEach>
    </div>
</div>

<!-- 이미지 상세 모달 -->
<div class="modal fade" id="commentImageModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">이미지 보기</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <img src="" id="modalImage" style="width: 100%;">
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
            </div>

        </div>
    </div>
</div>
</body>
</html>