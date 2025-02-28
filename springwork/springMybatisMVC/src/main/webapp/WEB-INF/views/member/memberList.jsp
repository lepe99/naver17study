<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
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

        #memberListTable img {
            width: 30px;
            height: 30px;
            object-fit: cover;
        }
    </style>
    <script>
        $(document).ready(function () {
            getAllMembers();

            // 전체 선택
            $("#checkAll").click(() => {
                if ($("#checkAll").prop("checked")) {
                    $(".checkMember").prop("checked", true);
                } else {
                    $(".checkMember").prop("checked", false);
                }
            });

            // 삭제 버튼 클릭 시
            $("#memberListTable").on("click", ".deleteMember", (e) => {
                let num = e.target.value;
                if (confirm("정말 삭제하시겠습니까?")) {
                    deleteMember(num);
                }
            });

            // 선택 회원 삭제
            $("#deleteMembers").click(() => {
                let nums = [];
                $(".checkMember").each((i, e) => {
                    if ($(e).prop("checked")) {
                        nums.push($(e).val());
                    }
                });
                if (nums.length === 0) {
                    alert("선택된 회원이 없습니다.");
                    return;
                }

                if (confirm("정말 삭제하시겠습니까?")) {
                    deleteMembers(nums);
                }
            });
        });

        // 회원 목록 가져오기
        function getAllMembers() {

            $.ajax({
                url: "getAllMembers",
                type: "post",
                dataType: "json",
                success: (response) => {
                    let s = "";
                    if (response.length === 1) {
                        s = "<tr><td colspan='5'>회원이 없습니다.</td></tr>";
                    }
                    let frontUrl;
                    let backUrl;
                    $.each(response, (i, e) => {
                        if (i === 0) {
                            frontUrl = e.frontUrl;
                            backUrl = e.backUrl;
                        }
                        // admin 계정은 조회 안되게 (num 1)
                        if (e.num !== 1 && i !== 0) {
                            let image = e.image === null ? "../image/noimg.jpg" : frontUrl + "/member/" + e.image + backUrl;
                            s += `
                            <tr>
                                <td><input type="checkbox" class="checkMember" value="\${e.num}"> \${e.name}</td>
                                <td>
<!--                                    <img src="../save/\${image}"> \${e.id}-->
                                    <a href=""><img src="\${image}" class="tableImage"> \${e.id}</a>
                                <td>\${e.hp}</td>
                                <td>\${e.address}</td>
                                <td><button class="btn btn-danger deleteMember" value="\${e.num}">삭제</button></td>
                            </tr>
                            `;
                        }
                    });
                    $("#memberListTable tbody").html(s);
                }
            });
        }

        // 회원 삭제
        function deleteMember(num) {
            $.ajax({
                url: "deleteMember",
                type: "post",
                dataType: "json",
                data: {num: num},
                success: (response) => {
                    if (response.result === "success") {
                        alert("삭제되었습니다.");
                        getAllMembers();
                    } else {
                        alert("삭제 실패");
                    }
                }
            });
        }

        // 선택한 회원 삭제
        function deleteMembers(nums) {
            $.ajax({
                url: "deleteMembers",
                type: "post",
                dataType: "json",
                data: {nums: nums},
                success: (response) => {
                    if (response.result === "success") {
                        alert("삭제되었습니다.");
                        getAllMembers();
                    } else {
                        alert("삭제 실패");
                    }
                }
            });
        }
    </script>
</head>
<body>
<jsp:include page="../layout/title.jsp" />
<div style="margin: 30px;">
    <h3>회원 목록</h3>
    <table class="table table-bordered" id="memberListTable">
        <thead>
        <tr>
            <th><input type="checkbox" id="checkAll"> 회원명</th>
            <th>아이디</th>
            <th>핸드폰</th>
            <th>주소</th>
            <th>삭제</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
    <button type="button" class="btn btn-danger" id="deleteMembers">선택 회원 삭제</button>
</div>
</body>
</html>