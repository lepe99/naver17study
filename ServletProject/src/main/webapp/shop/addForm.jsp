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
<div style="margin: 20px; width: 500px;">
    <form action="./insert" method="post">
        <table class="table table-bordered">
            <tr>
                <td style="width: 100px; background-color: lightgray;">상품사진</td>
                <td>
                    <select id="prdtImage" name="prdtImage" class="form-select">
                        <c:forEach var="i" begin="1" end="34">
                            <option value="../image/photo2/${i}.${i == 24 ? 'gif' : 'jpg'}">상품 ${i}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <img src="" class="shopPhoto" width="100">

                    <script>
                        $(".shopPhoto").attr("src", $("#prdtImage").val());

                        //이벤트
                        $("#prdtImage").change((e) => {
                            $(".shopPhoto").attr("src", $(e.target).val());
                        });
                    </script>
                </td>
            </tr>
            <tr>
                <td style="background-color: lightgray;">상품명</td>
                <td>
                    <input type="text" name="prdtName" id="prdtName" class="form-control">
                </td>
            </tr>
            <tr>
                <td style="background-color: lightgray;">상품색상</td>
                <td>
                    <input type="color" name="prdtColor" id="prdtColor" value="#ffccff">
                </td>
            </tr>
            <tr>
                <td style="background-color: lightgray;">상품가격</td>
                <td>
                    <input type="text" name="prdtPrice" id="prdtPrice" class="form-control">
                </td>
            </tr>
            <tr>
                <td style="background-color: lightgray;">상품갯수</td>
                <td>
                    <input type="number" name="prdtCnt" id="prdtCnt" class="form-control" min="1" max="10" value="1">
                </td>
            </tr>
            <tr>
                <td style="background-color: lightgray;">입고일</td>
                <td>
                    <input type="date" name="prdtDateIn" id="prdtDateIn" class="form-control" value="2025-01-01">
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <button type="submit" style="width: 120px;" class="btn btn-sm btn-success">등록하기</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>