<%@ page import="shop.data.ShopDao" %>
<%@ page import="shop.data.ShopDto" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<%
    int num = Integer.parseInt(request.getParameter("num"));
    ShopDao dao = new ShopDao();
    ShopDto dto = dao.getData(0, num, null).get(0);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
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
    <script src="main.js"></script>
    <script src="detail.js"></script>
    <style>
        body * {
            font-family: 'Jua', sans-serif;
        }
    </style>
</head>
<body>
<div style="margin: 20px; width: 500px">
    <!-- 상세정보 -->
    <div>
        <h3>상세정보</h3>
        <table style="width: 500px; border: 1px solid #ccc;">
            <tr>
                <td rowspan="2">
                    <img src="<%= dto.getPrdtImg() %>" class="thumbnail img-thumbnail" style="width: 200px;">
                </td>
                <td>
                    <span>상품명 : <%= dto.getPrdtName() %></span><br>
                    <span>색상 : <%= dto.getPrdtColor() %></span><br>
                    <span>수량 : <%= dto.getPrdtCnt() %></span><br>
                    <span>가격 : <%= dto.getPrdtPrice() %></span><br>
                    <span>입고일 : <%= dto.getPrdtDateIn() %></span>
                </td>
            </tr>
            <tr>
                <td>
                    <button class="btn btn-success mod" num="<%= dto.getNum() %>" onclick=openModModal()>수정</button>
                    <button class="btn btn-danger" onclick=deletePrdt(<%= dto.getNum() %>)>삭제</button>
                    <button class="btn btn-primary" onclick="location.href='main.html'">목록</button>
                </td>
            </tr>
        </table>
    </div>

    <!-- 리뷰 입력창 -->
    <div style="margin-top: 10px;">
        <form id="commentForm" action="../day0206_ajaxComment/insert.jsp" method="get">
            <div class="input-group">
                <input type="hidden" id="commentNum" name="num" value="<%= dto.getNum() %>">
                <select class="form-select" id="star" name="star">
                    <option value="1">★☆☆☆☆</option>
                    <option value="2">★★☆☆☆</option>
                    <option value="3">★★★☆☆</option>
                    <option value="4">★★★★☆</option>
                    <option value="5" selected>★★★★★</option>
                </select>
                <input type="text" class="form-control" id="comment" style="width: 260px;"
                       placeholder="리뷰를 입력하세요" id="review" name="message" required>
                <button type="submit" class="btn btn-primary" id="addComment">등록</button>
            </div>
        </form>
    </div>

    <!-- 댓글 리스트 -->
    <hr>
    <span style="font-size: 20px;" id="commentLength">리뷰</span>
    <select id="commentOrder" class="form-select" style="width: 100px; float: right;">
        <option value="1">최신순</option>
        <option value="2">등록순</option>
    </select>
    <hr>
    <div id="commentList">
        <!-- 여기에 댓글이 추가됩니다. -->
    </div>
</div>
</body>
</html>