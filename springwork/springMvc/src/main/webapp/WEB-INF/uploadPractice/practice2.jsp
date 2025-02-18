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
    </style>
</head>
<body>
<div style="margin: 30px;">
    <form action="practice2Process" method="post" enctype="multipart/form-data">
        제목 : <input type="text" name="title" required><br>
        사진
        <button type="button" id="addPhotoList">+</button>
        <hr>
        <input type="file" name="photo" required multiple>
        <div id="photoList"></div>
        <hr>
        <button type="submit">전송</button>
    </form>
</div>
<script>
    let listCounter = 0

    $("#addPhotoList").click(() => {
        let s = `
            <div id="photo_\${listCounter}">
                <input type="file" name="photo" required multiple>
                <button type="button" class="removePhotoList" value="\${listCounter}">-</button>
            </div>
            `;
        $("#photoList").append(s);
        listCounter++;
    });

    $(document).on("click", ".removePhotoList", (e) => {
        let id = e.target.value;
        $(`#photo_\${id}`).remove();
    });
</script>
</body>
</html>