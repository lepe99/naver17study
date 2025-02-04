<?xml version="1.0" encoding="utf-8" ?>
<%@ page import="memo.data.MemoDto" %>
<%@ page import="memo.data.MemoDao" %>
<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String avatar = request.getParameter("avatar");
    String nickname = request.getParameter("nickname");
    String message = request.getParameter("message");

    MemoDto dto = new MemoDto();
    dto.setAvatar(avatar);
    dto.setNickname(nickname);
    dto.setMessage(message);

    MemoDao dao = new MemoDao();
    dao.insertData(dto);
%>
<data>
    <result><%= nickname %>님의 메모를 DB에 추가했습니다.</result>
</data>

