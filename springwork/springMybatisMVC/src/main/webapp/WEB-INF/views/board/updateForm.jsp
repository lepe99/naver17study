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

        .formTable tbody th {
            background-color: cornflowerblue;
        }

        .uploadImage {
            width: 100px;
            height: 80px;
            object-fit: cover;
            border: 1px solid gray;
            margin-right: 10px;
            margin-bottom: 10px;
        }
    </style>
    <script>
        $(document).ready(function () {

            // 기존 이미지 리스트 얻기
            let beforeImages = [];
            // 이미지 태그의 src 속성에서 member/ 뒤의 파일명만 추출
            $(".uploadImage").each((i, e) => {
                beforeImages.push($(e).attr("src").split("/").pop());
            });


            // 이미지 삭제
            $("#beforeImageList").on("click", "i", (e) => {
                $(e.target).prev().remove();
                $(e.target).remove();
            });

            // uploadImageList에서 삭제한거라면 인풋 태그에서도 삭제
            $("#uploadImageList").on("click", "i", (e) => {
                $(e.target).prev().remove();
                $(e.target).remove();
            });

            // 이미지 수정 버튼 클릭 시
            $("#btnBoardUpdate").click((e) => {
                e.preventDefault(); // 기본 동작 중단

                // 이후 이미지 리스트 얻기
                let afterImages = [];
                // 이미지 태그의 src 속성에서 member/ 뒤의 파일명만 추출
                $(".uploadImage").each((i, e) => {
                    afterImages.push($(e).attr("src").split("/").pop());
                });

                // 기존 이미지와 이후 이미지 비교하여 삭제할 이미지 추출
                let deleteImages = beforeImages.filter(x => !afterImages.includes(x));

                let formData = new FormData($("#updateForm")[0]);

                deleteImages.forEach((image) => {
                    formData.append("deleteImages", image);
                });
                // 수정
                $.ajax({
                    url: "update",
                    type: "post",
                    data: formData,
                    dataType: "text",
                    processData: false,
                    contentType: false,
                    success: (response) => {
                        if (response === "success") {
                            alert("수정되었습니다.");
                            location.href = "detail?idx=${board.idx}&pageNum=${pageNum}";
                        } else {
                            alert("수정 실패");
                        }
                    }
                });
            });

            // 파일 선택 시 이미지 미리보기 추가
            $("#uploadFile").change((e) => {
                let files = e.target.files;
                let s = "";
                for (let i = 0; i < files.length; i++) {
                    let file = files[i];
                    s += `
                    <img src="\${URL.createObjectURL(file)}" class="uploadImage">
                    <i class="bi bi-trash" style="cursor: pointer;"></i>
                    `;
                    $("#uploadImageList").html(s);
                }
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
<div style="margin: 20px; width: 600px;">
    <form action="update" method="post" enctype="multipart/form-data" id="updateForm">
        <input type="hidden" name="idx" value="${board.idx}">
        <input type="hidden" name="regroup" value="${board.regroup}">
        <input type="hidden" name="restep" value="${board.restep}">
        <input type="hidden" name="relevel" value="${board.relevel}">
        <input type="hidden" name="pageNum" value="${pageNum}">

        <table class="table table-bordered formTable">
            <caption style="caption-side: top;">
                <h5>${board.restep == 0 ? "글 수정" : "답글 수정"}</h5>
            </caption>
            <tbody>
            <tr>
                <th style="width: 100px;">제 목</th>
                <td>
                    <input type="text" name="subject" class="form-control" required autofocus value="${board.subject}">
                </td>
            </tr>
            <tr>
                <th>사 진</th>
                <td>
                    <span id="beforeImageList" class="imageList">
                        <c:forEach var="image" items="${fileList}" varStatus="i">
                            <img src="${objectStorageUrl}/board/${image}" class="uploadImage">
                            <i class="bi bi-trash" style="cursor: pointer;"></i>
                        </c:forEach>
                    </span>
                    <span id="uploadImageList" class="imageList"></span>
                    <input type="file" name="upload" class="form-control" id="uploadFile" multiple>
                </td>
            </tr>
            <tr>
                <th>내 용</th>
                <td>
                    <textarea name="content" class="form-control" required
                              style="width: 100%; height: 150px;">${board.content}</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: right;">
                    <button type="submit" class="btn btn-outline-secondary" id="btnBoardUpdate">수정</button>
                    <button type="button" class="btn btn-outline-secondary" onclick="history.back()">취소</button>
                </td>
            </tr>
            </tbody>

        </table>
    </form>
</div>
</body>
</html>