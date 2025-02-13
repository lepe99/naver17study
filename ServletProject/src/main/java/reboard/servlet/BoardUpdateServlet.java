package reboard.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import reboard.data.BoardDao;
import reboard.data.BoardDto;

import java.io.IOException;

@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {
    BoardDao dao = new BoardDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        String pageNum = request.getParameter("pageNum");
        
        // subject, content 가져오기
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        
        // dto에 저장
        BoardDto dto = new BoardDto();
        dto.setNum(num);
        dto.setSubject(subject);
        dto.setContent(content);
        
        // update
        dao.updateBoard(dto);
        
        // redirect
        response.sendRedirect("./detail?num=" + num + "&pageNum=" + pageNum);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}