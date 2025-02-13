package reboard.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import reboard.data.BoardDao;
import reboard.data.BoardDto;

import java.io.IOException;
import java.util.List;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
    BoardDao dao = new BoardDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 검색 시 필요한 파라미터
        String field = request.getParameter("field");
        String search = request.getParameter("search");
        System.out.println("field: " + field + ", search: " + search);
        
        // 페이징 처리
        int perPage = 5; // 페이지 당 글의 개수
        int perBlock = 5; // 한 블록 당 출력 할 페이지 수
        int totalCount;
        if (search == null) totalCount = dao.getTotalCount(); // 전체 게시물 수
        else totalCount = dao.getSearchCount(field, search); // 검색된 게시물 수
        System.out.println("totalCount: " + totalCount);
        
        int totalPage = (int) Math.ceil((double) totalCount / perPage); // 전체 페이지 수 / 올림 처리
        int startNum; // 각 페이지에서 가져올 글의 시작 번호
        int startPage; // 시작 페이지
        int endPage; // 끝 페이지
        int no; // 각 페이지에서 출력할 시작 번호
        int pageNum; // 현재 페이지
        
        // 현재 페이지 얻기 (파라미터로 넘어오지 않으면 1로 초기화)
        try {
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        } catch (NumberFormatException e) {
            pageNum = 1;
        }
        
        // 시작 페이지, 끝 페이지 입력
        startPage = ((pageNum - 1) / perBlock) * perBlock + 1;
        endPage = startPage + perBlock - 1;
        // 끝 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
        if (endPage > totalPage) endPage = totalPage;
        
        // 각 페이지에서 가져올 글의 시작 번호
        startNum = (pageNum - 1) * perPage; // limit 0, 5 -> 0번부터 5개
        
        // limit에 맞는 값 넣어 list 가져오기
        List<BoardDto> list;
        if (search == null) list = dao.selectPagingList(startNum, perPage);
        else list = dao.selectSearchList(field, search, startNum, perPage);
        
        
        // 글이 1개만 있는 마지막 페이지에서 글을 삭제했을 때 이전 페이지로 이동
        if (list.isEmpty() && pageNum > 1) {
            response.sendRedirect("./list?pageNum=" + (pageNum - 1));
        }
        
        // 각 페이지에서 출력할 시작 번호 (글 번호 역순)
        no = totalCount - (pageNum - 1) * perPage;
        
        // request 객체에 totalCount, list를 저장
        request.setAttribute("totalCount", totalCount);
        request.setAttribute("list", list);
        
        // 추가로 페이징 처리에 필요한 값들을 request 객체에 저장
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("no", no);
        
        request.setAttribute("field", field);
        request.setAttribute("search", search);
        
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("./boardList.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}