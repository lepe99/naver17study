package reboard.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import reboard.data.BoardDao;
import reboard.data.BoardDto;

import java.io.IOException;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
    BoardDao dao = new BoardDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // pageNum 가져오기 (여기서 사용 안할거라 String으로 받음)
        String pageNum = request.getParameter("pageNum");
        
        int num = Integer.parseInt(request.getParameter("num"));
        dao.updateReadCount(num); // 조회수 증가
        
        // dto 가져오기
        BoardDto dto = dao.getData(num);
        
        // request 객체에 저장
        request.setAttribute("dto", dto);
        request.setAttribute("pageNum", pageNum);
        
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("./content.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}