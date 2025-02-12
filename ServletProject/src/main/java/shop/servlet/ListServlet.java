package shop.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import shop.data.ShopDao;
import shop.data.ShopDto;

import java.io.IOException;
import java.util.List;

@WebServlet("/shop/list")
public class ListServlet extends HttpServlet {
    ShopDao dao = new ShopDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int totalCount = dao.getTotalCount();
        List<ShopDto> list = dao.getAllDatas();
        
        // request 객체에 totalCount, list를 저장
        request.setAttribute("totalCount", totalCount);
        request.setAttribute("list", list);
        
        // 포워딩
        RequestDispatcher rd = request.getRequestDispatcher("./shopList.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}