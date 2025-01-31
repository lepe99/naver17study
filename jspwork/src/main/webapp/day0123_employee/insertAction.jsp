<%@ page import="employee.data.EmployeeDto" %>
<%@ page import="employee.data.EmployeeDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // form data 받기
    String empName = request.getParameter("empName");
    String empPhoto = request.getParameter("empPhoto");
    String empJoin = request.getParameter("empJoin");
    int empBirth = Integer.parseInt(request.getParameter("empBirth"));
    String empBlood = request.getParameter("empBlood");

    // dto 객체 생성 후 데이터 저장
    EmployeeDto dto = new EmployeeDto();
    dto.setEmpName(empName);
    dto.setEmpPhoto(empPhoto);
    dto.setEmpJoin(empJoin);
    dto.setEmpBirth(empBirth);
    dto.setEmpBlood(empBlood);

    // dao 선언 후 insert 메소드 호출
    EmployeeDao dao = new EmployeeDao();
    dao.insertData(dto);

    // 목록으로 이동
    response.sendRedirect("empList.jsp");
%>