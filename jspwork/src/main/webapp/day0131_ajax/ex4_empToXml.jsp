<?xml version="1.0" encoding="UTF-8"?>  <!-- XML 선언 -->
<%@ page import="employee.data.EmployeeDao" %>
<%@ page import="employee.data.EmployeeDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8" %>
<data>
    <%
        EmployeeDao dao = new EmployeeDao();
        String search = request.getParameter("search");
        List<EmployeeDto> list = dao.getAllData(search);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        for (EmployeeDto dto : list) { %>
    <emp num="<%= dto.getNum() %>">
        <eName><%= dto.getEmpName() %>
        </eName>
        <ePhoto><%= dto.getEmpPhoto() %>
        </ePhoto>
        <eBlood><%= dto.getEmpBlood() %>
        </eBlood>
        <eBirth><%= dto.getEmpBirth() %>
        </eBirth>
        <hireDate><%= dto.getEmpJoin() %>
        </hireDate>
        <writeDate><%= sdf.format(dto.getWriteDate()) %>
        </writeDate>
    </emp>
    <% } %>
</data>