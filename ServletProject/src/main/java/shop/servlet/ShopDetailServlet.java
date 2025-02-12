package shop.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import shop.data.ShopDao;
import shop.data.ShopDto;

import java.io.IOException;

@WebServlet("/shop/detail")
public class ShopDetailServlet extends HttpServlet {
    ShopDao dao = new ShopDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        ShopDto dto = dao.getShop(num);
        
        // request 객체에 dto를 저장 후 포워딩
        request.setAttribute("dto", dto);
        RequestDispatcher rd = request.getRequestDispatcher("./shopDetail.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}