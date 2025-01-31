<%@ page import="employee.data.EmployeeDao" %>
<%@ page import="employee.data.EmployeeDto" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>502 jsp study</title>
    <link
            href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
            rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <style>
        body * {
            font-family: 'Jua', sans-serif;
        }

        .tab th {
            background-color: #ddd;
            text-align: center;
        }

        .tab .photo {
            width: 40px;
            height: 40px;
            border: 1px solid black;
            margin-right: 10px;
        }
    </style>
    <script>
        window.onload = () => {
            // 검색 버튼 이벤트
            document.getElementById("btnSearch").addEventListener("click", () => {
                // 검색단어 가져오기
                let search = document.getElementById("search").value;
                // 목록파일로 이동, 검색단어는 get 방식으로 전달
                location.href = `empList.jsp?search=\${search}`;
                // js 에서 템플릿 리터럴 사용 시 $ 앞에 \ 를 붙여준다 (jsp에서의 <%-- ${} --%> 와 구분)
            });

            // 검색단어 입력 후 엔터 누르면 검색하기
            document.getElementById("search").addEventListener("keyup", (e) => {
                if (e.keyCode === 13) {
                    document.getElementById("btnSearch").click();
                }
            });
        };
    </script>
</head>
<%
    // 검색 단어 search 읽기
    // empList.jsp 를 직접 실행시 search 값이 없다 -> search = null
    String search = request.getParameter("search");

    // dao 생성
    EmployeeDao dao = new EmployeeDao();

    // 전체 데이터 가져오기
    List<EmployeeDto> list = dao.getAllData(search);
%>
<body>
<div style="margin: 30px;">
    <table class="tab table table-bordered" style="width: 420px;">
        <caption align="top">
            <b>[사원목록] : <%= list.size() %>명</b>
            <button class="btn btn-success btn-sm" style="float: right;"
                    onclick="location.href='empForm.jsp'">사원등록
            </button>
            <br>
            <label class="input-group" style="margin-top: 20px;">
                <b>이름검색</b>&nbsp;&nbsp;
                <i class="bi bi-search"></i>
                <input type="text" id="search" placeholder="검색할 이름 입력" class="form-control">&nbsp;
                <button class="btn btn-info btn-sm" id="btnSearch">검색</button>
            </label>
        </caption>
        <thead>
        <tr>
            <th style="width: 50px;">번호</th>
            <th style="width: 150px;">사원명</th>
            <th style="width: 130px;">입사일</th>
            <th>상세보기</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (list.isEmpty()) { %>
        <tr style="height: 50px;">
            <td colspan="4" align="center"><b>등록된 사원이 없습니다.</b></td>
        </tr>
        <% } else {
            for (EmployeeDto dto : list) { %>
        <tr style="text-align: center">
            <td><%= dto.getNum() %>
            </td>
            <td>
                <img src="<%= dto.getEmpPhoto() %>" class="photo" alt="empPhoto">
                <%= dto.getEmpName() %>
            </td>
            <td><%= dto.getEmpJoin() %>
            </td>
            <td>
                <button type="button" class="btn btn-sm btn-info"
                        onclick="location.href='./empDetail.jsp?num=<%=dto.getNum()%>'">상세보기
                </button>
            </td>
        </tr>
        <% }
        } %>
        </tbody>
    </table>
</div>
</body>
</html>