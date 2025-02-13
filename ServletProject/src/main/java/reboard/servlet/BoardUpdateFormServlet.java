package reboard.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import reboard.data.BoardDao;
import reboard.data.BoardDto;

import java.io.IOException;

@WebServlet("/board/updateForm")
public class BoardUpdateFormServlet extends HttpServlet {
    BoardDao dao = new BoardDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // num, pageNum 가져오기
        int num = Integer.parseInt(request.getParameter("num"));
        String pageNum = request.getParameter("pageNum");
        
        BoardDto dto = dao.getData(num);
        String subject = dto.getSubject();
        String content = dto.getContent();
        
        // request 객체에 저장
        request.setAttribute("num", num);
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("subject", subject);
        request.setAttribute("content", content);
        
        // forward
        RequestDispatcher dispatcher = request.getRequestDispatcher("/board/updateForm.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}