package shop.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/shop/addForm")
public class AddFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // RequestDispatcher 객체를 생성
        RequestDispatcher rd = request.getRequestDispatcher("./addForm.jsp");
        // addForm.jsp로 포워딩
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doGet 메서드 호출
        doGet(request, response);
    }
}