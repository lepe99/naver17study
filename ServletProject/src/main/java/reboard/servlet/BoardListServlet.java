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
        int totalCount = dao.getTotalCount(); // 전체 게시물 수
        List<BoardDto> list = dao.selectPagingList(0, 50); // 일단 50개만 가져오기, 페이징 처리는 나ㅇ중에
        
        // request 객체에 totalCount, list를 저장
        request.setAttribute("totalCount", totalCount);
        request.setAttribute("list", list);
        
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("./boardList.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}