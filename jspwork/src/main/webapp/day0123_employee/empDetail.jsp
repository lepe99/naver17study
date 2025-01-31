<%@ page import="employee.data.EmployeeDao" %>
<%@ page import="employee.data.EmployeeDto" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

        .photo {
            width: 250px;
        }
    </style>
</head>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    EmployeeDao dao = new EmployeeDao();
    EmployeeDto dto = dao.getEmployeeData(num);
%>
<body>
<div style="margin: 20px">
    <h3><b>[<%=dto.getEmpName()%>] 사원 정보</b></h3>
    <img src="<%= dto.getEmpPhoto() %>" class="photo" alt="empPhoto"
         align="left" hspace="10" border="2"><br><br><br>
    <h5>입사일 : <%= dto.getEmpJoin() %></h5><br>
    <%
        // 현재 년도 구하기
        int CurrentYear = new Date().getYear() + 1900;
    %>
    <h5>나이 : <%= CurrentYear - dto.getEmpBirth() + 1%>세 (<%= dto.getEmpBirth() %>년생)</h5><br>
    <h5>혈액형 : <%= dto.getEmpBlood() %>형</h5><br>
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    %>
    <h5>등록일 : <%= sdf.format(dto.getWriteDate()) %></h5><br><br>
</div>
<div style="margin-left: 50px;">
    <button class="btn btn-outline-secondary btn-sm" onclick="location.href='empForm.jsp'">사원등록</button>
    <button class="btn btn-outline-secondary btn-sm" onclick="location.href='empList.jsp'">사원목록</button>
    <button class="btn btn-outline-secondary btn-sm"
            onclick="location.href='empUpdateForm.jsp?num=<%= dto.getNum() %>'">정보수정</button>

    <!-- 확인 없이 -->
<%--    <button class="btn btn-outline-secondary btn-sm" --%>
<%--            onclick="location.href='deleteAction.jsp?num=<%= dto.getNum() %>'">사원삭제</button>--%>

    <button class="btn btn-outline-secondary btn-sm" onclick="delFunc(<%= dto.getNum() %>)">사원삭제</button>
    <script type="text/javascript">
        function delFunc(num) {
            let ans = confirm("현재 사원을 DB 에서 삭제합니다");
            if (ans) {
                location.href = "deleteAction.jsp?num=" + num;
            }
        }
    </script>
</div>
</body>
</html>