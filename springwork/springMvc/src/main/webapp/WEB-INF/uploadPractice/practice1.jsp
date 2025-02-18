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
    <form action="practice1Process" method="post" enctype="multipart/form-data">
        제목 : <input type="text" name="title" id="title1" required><br>
        사진 : <input type="file" name="photo" id="photo1" required><br>
    </form>
    <hr>
    <figure>
        <figcaption><h5 class="title"></h5></figcaption>
        <img src="" class="photo" style="max-width: 200px;">
    </figure>
</div>
<script>
    $("#photo1").change((e) => {
        const title = $("#title1").val();
        const file = e.target.files[0];
        let formData = new FormData();
        formData.append("photo", file);
        formData.append("title", title);

        $.ajax({
            url: "practice1Process",
            type: "post",
            dataType: "json",
            data: formData,
            contentType: false,
            processData: false,
            success: (res) => {
                $(".title").html(res.title);
                $(".photo").attr("src", "save/" + res.photo);
            },
            error: (xhr) => {
                console.log(xhr);
            }
        });
    });
</script>
</body>
</html>