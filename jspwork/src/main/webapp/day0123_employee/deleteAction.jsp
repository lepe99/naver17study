<%@ page import="employee.data.EmployeeDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    // num 읽음
    int num = Integer.parseInt(request.getParameter("num"));

    // dao 생성, 삭제 메서드 호출
    EmployeeDao dao = new EmployeeDao();
    dao.deleteEmployeeData(num);

    // 목록으로 이동
    response.sendRedirect("empList.jsp");
%>