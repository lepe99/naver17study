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
    <table>
        <tr>
            <td style="text-align: center; vertical-align: middle; width: 250px;">
                <img src="${dto.prdtImage}" style="width: 200px; border: 2px solid black;">
            </td>
            <td style="vertical-align: middle;">
                <h5>상품명 : ${dto.prdtName}</h5>
                <h5>색 상 :
                    <div style="display: inline-block; background-color: ${dto.prdtColor}">${dto.prdtColor}</div>
                </h5>
                <h5>수량 : ${dto.prdtCnt}개</h5>
                <h5>가격 :
                    <fmt:formatNumber value="${dto.prdtPrice}" type="currency"
                                      currencySymbol="￦" maxFractionDigits="0"/>
                </h5>
                <h5>입고일 : ${dto.prdtDateIn}</h5>
                <h5>등록일 :
                    <fmt:formatDate value="${dto.dateWrite}" pattern="yyyy-MM-dd HH:mm"/>
                </h5>
            </td>
        </tr>
        <tr style="height: 50px;">
            <td colspan="2" style="text-align: center;">
                <button type="button" class="btn btn-sm btn-outline-secondary" style="width: 100px;"
                        onclick="location.href='./addForm'">상품등록
                </button>

                <button type="button" class="btn btn-sm btn-outline-secondary" style="width: 100px;"
                        onclick="location.href='./list'">상품목록
                </button>

                <button type="button" class="btn btn-sm btn-outline-secondary" style="width: 100px;"
                        onclick="location.href='./updateForm?num=${dto.num}'">상품수정
                </button>

                <button type="button" class="btn btn-sm btn-outline-secondary" style="width: 100px;"
                        onclick="location.href='./delete?num=${dto.num}'">상품삭제
                </button>
            </td>
        </tr>
    </table>
</div>
</body>
</html>