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

        div.photos img {
            width: 200px;
            height: 200px;
            border: 2px solid gray;
            border-radius: 20px;
            margin: 10px;
        }
    </style>
</head>
<body>
<h4 class="alert alert-danger">ajax 로 여러 사진 업로드</h4>
<input type="file" id="photoUpload" multiple>
<hr>
<div class="photos" style="margin: 20px;"></div>
<script>
    $("#photoUpload").change((e) => {
        const files = e.target.files;
        let formData = new FormData();
        for (let i = 0; i < files.length; i++) {
            formData.append("upload", files[i]);
        }
        $.ajax({
            url: "ajaxMultiProcess",
            type: "post",
            data: formData,
            dataType: "json",
            processData: false,
            contentType: false,
            success: (res) => {
                $.each(res, (i, e) => {
                    $(".photos").append(`<img src="save/\${e.photo}">`);
                });
            }
        });
    });
</script>
</body>
</html>