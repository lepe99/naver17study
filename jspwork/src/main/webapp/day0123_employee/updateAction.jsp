<%@ page import="employee.data.EmployeeDao" %>
<%@ page import="employee.data.EmployeeDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // dto 들어갈 값 얻어오기
    int num = Integer.parseInt(request.getParameter("num"));
    String empName = request.getParameter("empName");
    String empPhoto = request.getParameter("empPhoto");
    String empJoin = request.getParameter("empJoin");
    int empBirth = Integer.parseInt(request.getParameter("empBirth"));
    String empBlood = request.getParameter("empBlood");

    // dto 생성 후 데이터 저장
    EmployeeDto dto = new EmployeeDto();
    dto.setNum(num);
    dto.setEmpName(empName);
    dto.setEmpPhoto(empPhoto);
    dto.setEmpJoin(empJoin);
    dto.setEmpBirth(empBirth);
    dto.setEmpBlood(empBlood);

    // dao 생성 후 update 메서드 호출
    EmployeeDao dao = new EmployeeDao();
    dao.updateEmployeeData(dto);

    // 상세보기 페이지로 이동
    response.sendRedirect("empDetail.jsp?num=" + num);
%>