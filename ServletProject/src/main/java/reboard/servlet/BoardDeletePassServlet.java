package reboard.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/board/deletePassForm")
public class BoardDeletePassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // num, pageNum 가져오기
        String num = request.getParameter("num");
        String pageNum = request.getParameter("pageNum");
        
        // request 객체에 저장
        request.setAttribute("num", num);
        request.setAttribute("pageNum", pageNum);
        
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("./deletePassForm.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}