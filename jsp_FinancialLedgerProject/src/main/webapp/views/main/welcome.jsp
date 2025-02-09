<%-- welcome.jsp --%>
<%@ page import="dto.UsersDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script src="../../js/welcome.js"></script>
<%
    UsersDto dto = (UsersDto) session.getAttribute("loginUser");
    String userName = dto.getUsername();
%>
<div>
    <h4><%= userName %>님 환영합니다!</h4>
    <hr>
    <form id="initBalanceForm">
        <label for="initBalance">가계부 시작 전에 <br>초기 잔고를 입력해 주세요</label>
        <br>
        <br>
        <div class="input-group">
            <input type="number" id="initBalance" name="initBalance" class="form-control" checked><br>
            <button type="submit" class="btn btn-primary">입력</button>
        </div>
    </form>
</div>