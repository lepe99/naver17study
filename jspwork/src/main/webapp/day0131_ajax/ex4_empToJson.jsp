<%@ page import="employee.data.EmployeeDao" %>
<%@ page import="employee.data.EmployeeDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    EmployeeDao dao = new EmployeeDao();
    String search = request.getParameter("search");
    List<EmployeeDto> list = dao.getAllData(search);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
[
<%
    int listSize = list.size();
    for (EmployeeDto dto : list) {
        listSize--;
%>    {
        "num": "<%= dto.getNum() %>",
        "eName": "<%= dto.getEmpName() %>",
        "ePhoto": "<%= dto.getEmpPhoto() %>",
        "eBlood": "<%= dto.getEmpBlood() %>",
        "eBirth": "<%= dto.getEmpBirth() %>",
        "hireDate": "<%= dto.getEmpJoin() %>",
        "writeDate": "<%= sdf.format(dto.getWriteDate()) %>"
    }<% if (listSize > 0) { %>,<% } %>
<% } %>
]