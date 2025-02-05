<%--<%@ page import="memo.data.MemoDao" %>--%>
<%--<%@ page import="memo.data.MemoDto" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dto" class="memo.data.MemoDto" scope="request" />
<jsp:useBean id="dao" class="memo.data.MemoDao" scope="application" />
<jsp:setProperty name="dto" property="*" />

<%
    dao.updateData(dto);
%>

<%--<%--%>
<%--    int idx = Integer.parseInt(request.getParameter("idx"));--%>
<%--    String avatar = request.getParameter("avatar");--%>
<%--    String nickname = request.getParameter("nickname");--%>
<%--    String message = request.getParameter("message");--%>

<%--    MemoDto dto = new MemoDto();--%>
<%--    dto.setIdx(idx);--%>
<%--    dto.setAvatar(avatar);--%>
<%--    dto.setNickname(nickname);--%>
<%--    dto.setMessage(message);--%>

<%--    MemoDao dao = new MemoDao();--%>
<%--    dao.updateData(dto);--%>
<%--%>--%>