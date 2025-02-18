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


        #photoUpload {
            display: none; /* 숨기기 */
        }

        #myPhoto {
            width: 300px;
            height: 300px;
            /* 사진 비율 그대로 유지 */
            object-fit: cover;
            border: 2px solid #ccc;
            border-radius: 150px;
        }

        #btnUpload {
            font-size: 30px;
            position: relative;
            left: -40px;
            top: 120px;
        }
    </style>
</head>
<body>
<div style="margin: 50px;">
    <input type="file" id="photoUpload">
    <img src="" id="myPhoto" onerror="this.src='image/noimg.jpg';" style="max-width: 400px;">
    <i class="bi bi-upload" id="btnUpload" style="cursor: pointer;"></i>

    <script>
        // 아이콘 누르면 파일 업로드 인풋 나오게
        $("#btnUpload").click(() => {
            $("#photoUpload").trigger("click");
        });

        $("#photoUpload").change((e) => {
            let form = new FormData();
            form.append("upload", e.target.files[0]); // 선택한 파일 하나
            // form.append("upload", $("#photoUpload")[0].files[0]); // 이것도 가능

            $.ajax({
                url: "ajaxProcess",
                type: "post",
                dataType: "json",
                data: form,
                processData: false, // 파일의 경우 데이터를 query string 형태로 전달하지 않음
                contentType: false, // 파일의 경우 content-type의 값이 multipart/form-data로 전달됨
                success: (res) => {
                    $("#myPhoto").attr("src", "save/" + res.photo);
                }
            });
        }); $("#photoUpload").change((e) => {
            let form = new FormData();
            form.append("upload", e.target.files[0]); // 선택한 파일 하나
            // form.append("upload", $("#photoUpload")[0].files[0]); // 이것도 가능

            $.ajax({
                url: "ajaxProcess",
                type: "post",
                dataType: "json",
                data: form,
                processData: false, // 파일의 경우 데이터를 query string 형태로 전달하지 않고 객체 그대로 전달
                contentType: false, // 파일의 경우 content-type의 값이 multipart/form-data로 전달됨
                // 이를 false로 설정하면 content-type을 자동(application/x-www-form-urlencoded)으로 설정하지 않음
                success: (res) => {
                    $("#myPhoto").attr("src", "save/" + res.photo);
                }
            });
        });
    </script>
</div>
</body>
</html>