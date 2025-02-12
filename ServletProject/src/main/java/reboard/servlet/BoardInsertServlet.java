package reboard.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import reboard.data.BoardDao;
import reboard.data.BoardDto;

import java.io.IOException;

@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
    BoardDao dao = new BoardDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BoardDto dto = new BoardDto();
        dto.setNum(Integer.parseInt(request.getParameter("num")));
        dto.setRegroup(Integer.parseInt(request.getParameter("regroup")));
        dto.setRestep(Integer.parseInt(request.getParameter("restep")));
        dto.setRelevel(Integer.parseInt(request.getParameter("relevel")));
        dto.setWriter(request.getParameter("writer"));
        dto.setPhoto(request.getParameter("photo"));
        dto.setSubject(request.getParameter("subject"));
        dto.setPasswd(request.getParameter("passwd"));
        dto.setContent(request.getParameter("content"));
        
        // insert
        dao.insertBoard(dto);
        
        // redirect
        response.sendRedirect("./list");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}