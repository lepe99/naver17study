package reboard.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import reboard.data.BoardDao;

import java.io.IOException;

@WebServlet("/board/delete")
public class BoardDeleteProcessServlet extends HttpServlet {
    BoardDao dao = new BoardDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // num, pageNum, passwd 가져오기
        int num = Integer.parseInt(request.getParameter("num"));
        String pageNum = request.getParameter("pageNum");
        String passwd = request.getParameter("passwd");
        
        // 비밀번호 확인
        boolean isPass = dao.checkPasswd(num, passwd);
        if (isPass) {
            // delete
            dao.deleteBoard(num);
            
            // redirect
            response.sendRedirect("./list?pageNum=" + pageNum);
        } else {
            // forward
            RequestDispatcher rd = request.getRequestDispatcher("./fail.jsp");
            rd.forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}