package shop.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import shop.data.ShopDao;

import java.io.IOException;

@WebServlet("/shop/delete")
public class DeleteServlet extends HttpServlet {
    ShopDao dao = new ShopDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        dao.deleteShop(num);
        
        // 삭제 후 list로 리다이렉트 - list 서블릿 호출
        response.sendRedirect("./list");
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}