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
<h2 class="alert alert-danger">HelloController 로부터 forward</h2>
<h4>메세지 : ${message}</h4>
<h4>오늘은 <fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>입니다</h4>
<hr>
<h5>매핑주소 연습</h5>
<h6>
    <a href="a/shop/addForm">a/shop/addForm 으로 이동</a>
</h6>
<h6>
    <a href="a/shop/updateForm">a/shop/updateForm 으로 이동</a>
</h6>
<h6>
    <a href="b/shop/list">b/shop/list 으로 이동</a>
</h6>
<h6>
    <a href="b/shop/cart">b/shop/cart 으로 이동</a>
</h6>
<h6>
    <a href="b/board/list">b/board/list 으로 이동</a>
</h6>
<hr>
<h6>
    <a href="prop1">application.yml 에서 addr, hp 읽기</a>
</h6>
<h6>
    <a href="prop2">naverCloud.properties 에서 정보 읽기</a>
</h6>
<hr>
<h6>
    <a href="form1">get 방식으로 form 데이터 각각 읽기</a>
</h6>
<h6>
    <a href="form2">post 방식 (dto)로 form 데이터 읽기</a>
</h6>
<h6>
    <a href="form3">post 방식 (map)로 form 데이터 읽기</a>
</h6>
<hr>
<h6>
    <a href="uploadForm">사진 업로드 폼</a>
</h6>
<h6>
    <a href="multiForm">사진 여러장 업로드 폼</a>
</h6>
<h6>
    <a href="ajaxUpload">ajax 로 사진 업로드</a>
</h6>
<h6>
    <a href="ajaxMultiUpload">ajax 로 여러 사진 업로드</a>
</h6>
<hr>
<h6>
    <a href="practice1">연습문제 1 : ajax 로 제목과 사진 업로드</a>
</h6>
<h6>
    <a href="practice2">연습문제 2 : 폼 단위 사진 추가, 삭제 기능</a>
</h6>
</body>
</html>