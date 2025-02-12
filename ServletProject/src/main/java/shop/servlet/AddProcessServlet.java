package shop.servlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import shop.data.ShopDao;
import shop.data.ShopDto;

import java.io.IOException;

@WebServlet("/shop/insert")
public class AddProcessServlet extends HttpServlet {
    ShopDao dao = new ShopDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopDto dto = new ShopDto();
        dto.setPrdtName(request.getParameter("prdtName"));
        dto.setPrdtColor(request.getParameter("prdtColor"));
        dto.setPrdtImage(request.getParameter("prdtImage"));
        dto.setPrdtDateIn(request.getParameter("prdtDateIn"));
        dto.setPrdtCnt(Integer.parseInt(request.getParameter("prdtCnt")));
        dto.setPrdtPrice(Integer.parseInt(request.getParameter("prdtPrice")));
        
        dao.insertShop(dto);
        
        // list로 리다이렉트 - list 서블릿 호출
        response.sendRedirect("./list");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}